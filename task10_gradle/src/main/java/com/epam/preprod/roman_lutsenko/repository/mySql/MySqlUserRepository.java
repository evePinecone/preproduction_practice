package com.epam.preprod.roman_lutsenko.repository.mySql;

import com.epam.preprod.roman_lutsenko.constant.DBCommands;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.db.util.ConnectionHolder;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.constant.DBCommands.SQL_FIND_USER_BY_PHONE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ADD_METHOD_REPOSITORY;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ERR_CANNOT_OBTAIN_USERS;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ERR_CANNOT_REMOVE_USER_FROM_DATABASE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.GET_ELEMENT_REPOSITORY;
import static com.epam.preprod.roman_lutsenko.constant.Messages.REMOVE_METHOD_REPOSITORY;
import static com.epam.preprod.roman_lutsenko.util.UserExtractor.extractUserFromResultSet;

public class MySqlUserRepository implements UserRepository{

    private static final Logger LOG = Logger.getLogger(MySqlUserRepository.class);


    public boolean add(User user) {
        LOG.debug(ADD_METHOD_REPOSITORY);
        PreparedStatement preparedStatement = null;
        int counter = 1;
        try {
            Connection connection = ConnectionHolder.getConnection();
            preparedStatement = connection.prepareStatement(DBCommands.SQL_ADD_USER);
            preparedStatement.setString(counter++, user.getName());
            preparedStatement.setString(counter++, user.getEmail());
            preparedStatement.setString(counter++, user.getPhone());
            preparedStatement.setString(counter, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(ERR_CANNOT_OBTAIN_USERS, e);
        }
        return true;
    }

    @Override
    public boolean remove(String phone) {
        LOG.debug(REMOVE_METHOD_REPOSITORY);
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = ConnectionHolder.getConnection();
            preparedStatement = connection.prepareStatement(DBCommands.SQL_REMOVE_USER_BY_PHONE);
            preparedStatement.setString(1, phone);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(ERR_CANNOT_REMOVE_USER_FROM_DATABASE, e);
            throw new DBException(ERR_CANNOT_REMOVE_USER_FROM_DATABASE, e);
        }
        return true;
    }

    public User getById(String phone) {
        LOG.debug(GET_ELEMENT_REPOSITORY);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        Connection connection = ConnectionHolder.getConnection();
        LOG.debug("connection get = " + connection);
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_PHONE);
            preparedStatement.setString(1, phone);
            LOG.debug("prepSt = " + preparedStatement);
            resultSet = preparedStatement.executeQuery();
            user = extractUserFromResultSet(resultSet);
            LOG.debug("user = " + user);
        } catch (SQLException e) {
            LOG.error(ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(ERR_CANNOT_OBTAIN_USERS, e);
        }
        return user;
    }

    @Override
    public Map<String, User> getAllUsers() {
        Map<String, User> userMap = new HashMap<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionHolder.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DBCommands.SQL_FIND_ALL_FIELDS);
            while (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                userMap.put(user.getPhone(),user);
            }
        } catch (SQLException e) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USERS, e);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USERS, e);
        }
        return userMap;
    }
}
