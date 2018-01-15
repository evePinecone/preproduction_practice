package com.epam.preprod.roman_lutsenko.db;

/**
 * Interface in which need to include stack of method transaction.
 * @param <T>
 */
public interface IExecutable<T> {
    T executeTransaction();
}
