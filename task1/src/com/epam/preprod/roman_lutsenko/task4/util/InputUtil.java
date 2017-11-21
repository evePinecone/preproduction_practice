package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static LocalDateTime readDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("Enter date and time in format \"yyyy-MM-dd HH:mm\"");

        boolean correctParse = false;
        while (!correctParse) {
            String string = scanner.nextLine();
            try {
                localDateTime = ValidationUtil.parseDateTime(string);
                correctParse = true;
            } catch (DateTimeParseException ex) {
                System.out.println("Incorrect date format");
            }
        }
        return localDateTime;
    }
}
