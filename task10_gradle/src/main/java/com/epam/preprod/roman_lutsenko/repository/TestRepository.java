package com.epam.preprod.roman_lutsenko.repository;

import com.epam.preprod.roman_lutsenko.entities.Test;
import com.epam.preprod.roman_lutsenko.exception.DBException;

import java.util.Map;

public interface TestRepository {

    Map<Integer, Test> getAllFields() throws DBException;
}
