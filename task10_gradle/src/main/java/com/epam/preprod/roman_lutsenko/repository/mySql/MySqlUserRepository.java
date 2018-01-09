package com.epam.preprod.roman_lutsenko.repository.mySql;

import com.epam.preprod.roman_lutsenko.constant.DBCommands;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.db.util.DBUtil;
import com.epam.preprod.roman_lutsenko.entity.Test;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.constant.Messages.*;
import static com.epam.preprod.roman_lutsenko.util.UserExtractor.extractUserFromResultSer;

public class MySqlUserRepository implements UserRepository {

    private static final Logger LOG = Logger.getLogger(MySqlUserRepository.class);


    //todo: Realisation of db.
    @Override
    public void add(User user) {
        //todo: check if extists
        LOG.debug(ADD_METHOD_REPOSITORY);
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int counter = 1;
        try {
            preparedStatement = connection.prepareStatement(DBCommands.SQL_ADD_USER);
            preparedStatement.setString(counter++, user.getName());
            preparedStatement.setString(counter++, user.getEmail());
            preparedStatement.setString(counter++, user.getPhone());
            preparedStatement.setString(counter, user.getPassword());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(ERR_CANNOT_OBTAIN_USERS, e);
        } finally {
            DBUtil.close(connection);
            DBUtil.close(preparedStatement);
        }
    }

    @Override
    public Object remove(String phone) {
        LOG.debug(REMOVE_METHOD_REPOSITORY);
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DBCommands.SQL_REMOVE_USER_BY_PHONE);
            preparedStatement.setString(1, phone);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(ERR_CANNOT_REMOVE_USER_FROM_DATABASE, e);
            throw new DBException(ERR_CANNOT_REMOVE_USER_FROM_DATABASE, e);
        } finally {
            DBUtil.close(connection);
            DBUtil.close(preparedStatement);
        }
        //todo: check if extists and return the result
        return null;
    }

    @Override
    public User getById(String phone) {
        //todo: realisation.
        return null;
    }

    @Override
    public Map<String, User> getAllUsers() {
        Map<String, User> userMap = new HashMap<>();
        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DBCommands.SQL_FIND_ALL_FIELDS);
            while (resultSet.next()) {
                User user = extractUserFromResultSer(resultSet);
                userMap.put(user.getPhone(),user);
            }
            connection.commit();
        } catch (SQLException e) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USERS, e);
        }
        DBUtil.close(connection, statement, resultSet);
        return userMap;
    }
}
