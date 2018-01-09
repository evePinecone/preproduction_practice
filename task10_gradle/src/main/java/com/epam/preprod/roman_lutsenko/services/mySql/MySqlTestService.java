package com.epam.preprod.roman_lutsenko.services.mySql;

import com.epam.preprod.roman_lutsenko.dao.TestDAO;
import com.epam.preprod.roman_lutsenko.dao.mySql.MySqlTestDAO;
import com.epam.preprod.roman_lutsenko.entities.Test;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;
import com.epam.preprod.roman_lutsenko.services.TestService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Map;

public class MySqlTestService implements TestService{

    private static final Logger logger = Logger.getLogger(MySqlTestService.class);

    private TestDAO testDAO;

    public MySqlTestService() {
        this.testDAO = new MySqlTestDAO();
    }

    public Map<Integer, Test> getAllFields() {
        Map<Integer, Test> map = null;
        try {
            map = testDAO.getAllFields();
        } catch (DBException e) {
            logger.error(getClass(), e);
        }
        return map;
    }

    @Override
    public void getSQLException() throws SQLException {
        throw new SQLException();
    }
}
