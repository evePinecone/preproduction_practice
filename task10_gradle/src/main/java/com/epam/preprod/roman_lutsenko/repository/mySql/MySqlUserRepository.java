package com.epam.preprod.roman_lutsenko.repository.mySql;

import com.epam.preprod.roman_lutsenko.constant.DBCommands;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.db.util.TransactionManager;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import com.epam.preprod.roman_lutsenko.util.UserExtractor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.constant.Messages.ADD_METHOD_REPOSITORY;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ERR_CANNOT_OBTAIN_USERS;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ERR_CANNOT_REMOVE_USER_FROM_DATABASE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.GET_ELEMENT_REPOSITORY;
import static com.epam.preprod.roman_lutsenko.constant.Messages.REMOVE_METHOD_REPOSITORY;
import static com.epam.preprod.roman_lutsenko.util.UserExtractor.extractUserFromResultSet;

public class MySqlUserRepository implements UserRepository {

    private static final Logger LOG = Logger.getLogger(MySqlUserRepository.class);
    public static final String SQL_SELECT_FROM_SHOP_USER_WHERE_PHONE = "SELECT * FROM shop.user WHERE phone=?";

    @Override
    public boolean add(User user) {
        //todo: connection get back
        LOG.debug(ADD_METHOD_REPOSITORY);
        Connection connection = TransactionManager.getConnection();
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
            TransactionManager.close(connection);
            TransactionManager.close(preparedStatement);
        }
        return false;
    }

    @Override
    public boolean remove(String phone) {
        LOG.debug(REMOVE_METHOD_REPOSITORY);
        Connection connection = TransactionManager.getConnection();
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
            TransactionManager.close(connection);
            TransactionManager.close(preparedStatement);
        }
        return true;
    }

    @Override
    public User getById(String phone) {
        LOG.debug(GET_ELEMENT_REPOSITORY);
        Connection connection = TransactionManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_FROM_SHOP_USER_WHERE_PHONE);
            preparedStatement.setString(1, phone);
            resultSet = preparedStatement.executeQuery();
            user = UserExtractor.extractUserFromResultSet(resultSet);
        } catch (SQLException e) {
            LOG.error(ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(ERR_CANNOT_OBTAIN_USERS, e);
        } finally {
            TransactionManager.close(connection);
            TransactionManager.close(preparedStatement);
            TransactionManager.close(resultSet);
        }
        return user;
    }

    @Override
    public Map<String, User> getAllUsers() {
        Map<String, User> userMap = new HashMap<>();
        Connection connection = TransactionManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DBCommands.SQL_FIND_ALL_FIELDS);
            while (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                userMap.put(user.getPhone(),user);
            }
            connection.commit();
        } catch (SQLException e) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USERS, e);
        }
        TransactionManager.close(connection, statement, resultSet);
        return userMap;
    }
}
