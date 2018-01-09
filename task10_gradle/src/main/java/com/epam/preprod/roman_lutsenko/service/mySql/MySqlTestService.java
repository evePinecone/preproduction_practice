package com.epam.preprod.roman_lutsenko.service.mySql;

import com.epam.preprod.roman_lutsenko.repository.TestRepository;
import com.epam.preprod.roman_lutsenko.repository.mySql.MySqlTestRepository;
import com.epam.preprod.roman_lutsenko.entity.Test;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import com.epam.preprod.roman_lutsenko.service.TestService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Map;

public class MySqlTestService implements TestService {

    private static final Logger logger = Logger.getLogger(MySqlTestService.class);

    private TestRepository testRepository;

    public MySqlTestService() {
        this.testRepository = new MySqlTestRepository();
    }

    public Map<Integer, Test> getAllFields() {
        Map<Integer, Test> map = null;
        try {
            map = testRepository.getAllFields();
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
