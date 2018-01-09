package com.epam.preprod.roman_lutsenko.dao;

import com.epam.preprod.roman_lutsenko.entities.Test;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;

import java.sql.SQLException;
import java.util.Map;

public interface TestDAO {

    Map<Integer, Test> getAllFields() throws DBException;
}
