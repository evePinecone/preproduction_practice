package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtil {

    public static LocalDateTime parseDateTime(String timeInString) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(timeInString, format);
        } catch (DateTimeParseException ex) {
            System.out.println("Incorrect date format");
            return null;
        }
    }

}
