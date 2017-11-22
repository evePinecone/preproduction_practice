package com.epam.preprod.roman_lutsenko.task4.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtil {

    public static LocalDateTime parseDateTime(String timeInString) {
        if (!timeInString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            simpleDateFormat.setLenient(false);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(timeInString, format);
           // return LocalDateTime.parse(simpleDateFormat.parse(timeInString));
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect date format");
            return null;
        }
    }

    public static Integer parseInt(String intString) {
        if (intString.matches("\\d+")) {
            return Integer.parseInt(intString);
        }
        System.out.println("Non correct symbol, write int format symbol");
        return null;
    }

    public static Long parseLong(String longString) {
        if (longString.matches("\\d+")) {
            return Long.parseLong(longString);
        }
        System.out.println("Non correct symbol, write long format symbol");
        return null;
    }

    public static Double parseDouble(String intString) {
        if (intString.matches("\\d+\\.\\d+")) {
            return Double.parseDouble(intString);
        }
        System.out.println("Non correct symbol, write \"\\d+\\.\\d+\" format symbol");
        return null;
    }

}
