package com.epam.preprod.roman_lutsenko.task4.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Class contains validation methods for input input string to special format.
 */
public final class ValidationUtil {

    /**
     * Simple of input string.
     */
    private static final String DATE_PATTERN_VISUAL = "yyyy-MM-dd HH:mm";
    /**
     * Regex expression for date format.
     */
    private static final String DATE_REGEX = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
    /**
     * Regex expression for integer format.
     */
    private static final String INTEGER_REGEX = "\\d+";
    /**
     * Regex expression for double format number.
     */
    private static final String DOUBLE_REGEX = "\\d+\\.\\d+";

    /**
     * Blocked constructor.
     */
    private ValidationUtil() {
    }


    /**
     * Check input string is equal to date format.
     *
     * @param timeInString input string.
     * @return LocalDateTime formatted string.
     */
    public static LocalDateTime parseDateTime(String timeInString) {
        if (!timeInString.matches(DATE_REGEX)) {
            return null;
        }
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_PATTERN_VISUAL);
            return LocalDateTime.parse(timeInString, format);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect date format");
            return null;
        }
    }

    /**
     * Check input string is equal to Integer format.
     *
     * @param intString input string
     * @return Integer formatted string.
     */
    public static Integer parseInt(String intString) {
        if (intString.matches(INTEGER_REGEX)) {
            return Integer.parseInt(intString);
        }
        System.out.println("Non correct symbol, write int format symbol");
        return null;
    }

    /**
     * Check input string is equal to Integer format.
     *
     * @param longString input string
     * @return Long formatted string.
     */
    public static Long parseLong(String longString) {
        if (longString.matches(INTEGER_REGEX)) {
            return Long.parseLong(longString);
        }
        System.out.println("Non correct symbol, write long format symbol");
        return null;
    }

    /**
     * Check input string is equal to Double format.
     *
     * @param doubleString input string
     * @return Double formatted string.
     */
    public static Double parseDouble(String doubleString) {
        if (doubleString.matches(DOUBLE_REGEX)) {
            return Double.parseDouble(doubleString);
        }
        System.out.println("Non correct symbol, write \"" + DOUBLE_REGEX + "\" format symbol");
        return null;
    }

}
