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

    public static int intValidationInput() {
        Scanner scanner = new Scanner(System.in);
        int parseInt = 0;
        boolean flagUnParse = true;
        do {
            try {
                parseInt = Integer.parseInt(scanner.nextLine());
                flagUnParse = false;
            } catch (NumberFormatException ex) {
                System.out.println("Non correct symbol, write int format symbol");
            }
        } while (flagUnParse);
        return parseInt;
    }

    public static long longValidationInput() {
        Scanner scanner = new Scanner(System.in);
        long parseInt = 0;
        boolean flagUnParse = true;
        do {
            try {
                parseInt = Long.parseLong(scanner.nextLine());
                flagUnParse = false;
            } catch (NumberFormatException ex) {
                System.out.println("Non correct symbol, write long format symbol");
            }
        } while (flagUnParse);
        return parseInt;
    }

    public static double doubleValidationInput() {
        Scanner scanner = new Scanner(System.in);
        double parseInt = 0;
        boolean flagUnParse = true;
        do {
            try {
                parseInt = Double.parseDouble(scanner.nextLine());
                flagUnParse = false;
            } catch (NumberFormatException ex) {
                System.out.println("Non correct symbol, write double format symbol");
            }
        } while (flagUnParse);
        return parseInt;
    }


}
