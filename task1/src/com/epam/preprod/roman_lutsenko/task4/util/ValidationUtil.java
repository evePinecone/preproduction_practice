package com.epam.preprod.roman_lutsenko.task4.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtil {

    private static final String DATE_PATTERN_VISUAL = "yyyy-MM-dd HH:mm";
    private static final String DATE_REGEX = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
    private static final String INTEGER_REGEX = "\\d+";
    private static final String DOUBLE_REGEX = "\\d+\\.\\d+";


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

    public static Integer parseInt(String intString) {
        if (intString.matches(INTEGER_REGEX)) {
            return Integer.parseInt(intString);
        }
        System.out.println("Non correct symbol, write int format symbol");
        return null;
    }

    public static Long parseLong(String longString) {
        if (longString.matches(INTEGER_REGEX)) {
            return Long.parseLong(longString);
        }
        System.out.println("Non correct symbol, write long format symbol");
        return null;
    }

    public static Double parseDouble(String intString) {
        if (intString.matches(DOUBLE_REGEX)) {
            return Double.parseDouble(intString);
        }
        System.out.println("Non correct symbol, write \""+ DOUBLE_REGEX + "\" format symbol");
        return null;
    }

}
