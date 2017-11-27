package com.epam.preprod.roman_lutsenko.task1.filters;

public interface Filter<T> {
    boolean accept(T thing);
}