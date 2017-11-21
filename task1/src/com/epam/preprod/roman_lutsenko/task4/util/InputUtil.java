package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);


    public static LocalDateTime readDateTime() {
        LocalDateTime localDateTime = null;

        System.out.println("Enter date and time in format \"yyyy-MM-dd HH:mm\"");

        while (localDateTime == null) {
            String string = scanner.nextLine();
            localDateTime = ValidationUtil.parseDateTime(string);
        }
        return localDateTime;
    }
}

