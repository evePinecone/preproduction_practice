package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class InputUtil {

    private static final String EMPTY_STING = "";
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
        } while (isNull(parseInt));
        return parseInt;
    }

    public static long longValidationInput() {
        Long parseLong = null;
        do {
            parseLong = ValidationUtil.parseLong(scanner.next());
        } while (isNull(parseLong));
        return parseLong;
    }

    public static double doubleValidationInput() {
        Double parseDouble = null;
        do {
            parseDouble = ValidationUtil.parseDouble(scanner.next());
        } while (isNull(parseDouble));
        return parseDouble;
    }

    public static String stringValidationInput() {
        String string = null;
        do {
            string = scanner.nextLine();
        } while (Objects.equals(string, EMPTY_STING));
        return string;
    }
}

