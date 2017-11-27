package com.epam.preprod.roman_lutsenko.task4.util;

/**
 * Wrapper for incorrect id injection.
 * Throws if we have item with such id in shop.
 */
public class IncorrectIdException extends RuntimeException {
    public IncorrectIdException(String message) {
        super(message);
    }
}
