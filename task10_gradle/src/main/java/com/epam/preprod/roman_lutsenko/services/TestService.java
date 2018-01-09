package com.epam.preprod.roman_lutsenko.services;

import com.epam.preprod.roman_lutsenko.entities.Test;

import java.sql.SQLException;
import java.util.Map;

public interface TestService {

    Map<Integer, Test> getAllFields();
    void getSQLException() throws SQLException;
}
