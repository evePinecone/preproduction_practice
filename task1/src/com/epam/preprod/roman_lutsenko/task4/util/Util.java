package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Util {

    public static LocalDateTime readDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("Enter date and time in format \"yyyy-MM-dd HH:mm\"");
        Scanner scanner = new Scanner(System.in);

        boolean correctParse = false;
        while (!correctParse) {
            String string = scanner.nextLine();
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                localDateTime = LocalDateTime.parse(string, format);
                correctParse = true;
            } catch (DateTimeParseException ex) {
                System.out.println("Incorrect date format");
            }
        }
        return localDateTime;
    }
}
