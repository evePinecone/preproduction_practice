package com.epam.preprod.roman_lutsenko.repository.mySql;

import com.epam.preprod.roman_lutsenko.constants.DBCommands;
import com.epam.preprod.roman_lutsenko.db.util.DBUtil;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.constants.Messages.ERR_CANNOT_OBTAIN_USERS;

public class MySqlUserRepository implements UserRepository {

    private static final Logger LOG = Logger.getLogger(MySqlUserRepository.class);
//todo: Realisation of db.
    @Override
    public void add(User user) {
        LOG.debug("add method repository");
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
        return null;
    }

    @Override
    public User getById(String phone) {
        return null;
    }

    @Override
    public Map<String, User> getAllUsers() {
        return null;
    }
}
