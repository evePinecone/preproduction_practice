package com.epam.preprod.roman_lutsenko.service;

import com.epam.preprod.roman_lutsenko.entity.Test;

import java.sql.SQLException;
import java.util.Map;

public interface TestService {

    Map<Integer, Test> getAllFields();
    void getSQLException() throws SQLException;
}
