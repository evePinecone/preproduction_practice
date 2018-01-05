package com.epam.preprod.roman_lutsenko.services.mySqlImpl;

import com.epam.preprod.roman_lutsenko.dao.TestDAO;
import com.epam.preprod.roman_lutsenko.dao.mySqlImpl.MySqlTestDAO;
import com.epam.preprod.roman_lutsenko.entities.Test;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;
import com.epam.preprod.roman_lutsenko.services.TestService;
import org.apache.log4j.Logger;

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
}
