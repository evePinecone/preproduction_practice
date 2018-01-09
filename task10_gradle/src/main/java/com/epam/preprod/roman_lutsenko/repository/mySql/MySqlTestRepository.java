package com.epam.preprod.roman_lutsenko.repository.mySql;

import com.epam.preprod.roman_lutsenko.constant.DBCommands;
import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.repository.TestRepository;
import com.epam.preprod.roman_lutsenko.db.util.DBUtil;
import com.epam.preprod.roman_lutsenko.entity.Test;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MySqlTestRepository implements TestRepository {

    private static final Logger logger = Logger.getLogger(MySqlTestRepository.class);

    public MySqlTestRepository() {
        logger.trace(Messages.TRACE_DAO_OBJECT_CREATED + getClass().getSimpleName());
    }


    @Override
    public Map<Integer, Test> getAllFields() throws DBException {
        Map<Integer, Test> testMap = new HashMap<>();
        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DBCommands.SQL_FIND_ALL_FIELDS);
            while (resultSet.next()) {
                Test test = parseTest(resultSet);
                testMap.put(test.getId(),test);
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error(Messages.ERR_CANNOT_OBTAIN_TEST, e);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_TEST, e);
        }
        DBUtil.close(connection, statement, resultSet);
        return testMap;
    }

    private Test parseTest(ResultSet resultSet) throws SQLException {
        Test test = new Test();
        test.setId(resultSet.getInt(Fields.ID));
        test.setText(resultSet.getString(Fields.TEST_TEXT));
        test.setQweqwe(resultSet.getString(Fields.TEST_QWEQWE));
        return test;
    }
}
