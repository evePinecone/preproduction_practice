package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
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

    public static int intValidationInput() {
        Integer parseInt = null;
        do {
                parseInt = ValidationUtil.parseInt(scanner.nextLine());
        } while (parseInt == null);
        return parseInt;
    }

    public static long longValidationInput() {
        Long parseLong = null;
        do {
            parseLong = ValidationUtil.parseLong(scanner.next());
        } while (parseLong == null);
        return parseLong;
    }

    public static double doubleValidationInput() {
        Double parseDouble = null;
        do {
            parseDouble = ValidationUtil.parseDouble(scanner.next());
        } while (parseDouble == null);
        return parseDouble;
    }

    public static String stringValidationInput() {
        return scanner.nextLine();
    }
}

