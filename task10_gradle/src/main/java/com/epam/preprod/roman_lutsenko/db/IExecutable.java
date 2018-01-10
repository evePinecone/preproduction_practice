package com.epam.preprod.roman_lutsenko.db;

public interface IExecutable<T> {
    T executeTransaction();
}
