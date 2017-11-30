package com.epam.preprod.roman_lutsenko.task4.util;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Objects.isNull;

/**
 * Class contains input from keyboard methods for different types of data.
 */
public final class InputUtil {

    /**
     * Constant to introduce an empty string.
     */
    private static final String EMPTY_STING = "";

    /**
     * Scanner for all inputted data.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Blocked constructor.
     */
    private InputUtil() {
    }

    /**
     * Read and validate string in similar date form from console to LocalDateTime.
     *
     * @return LocalDateTime date.
     */
    public static LocalDateTime readDateTime() {
        LocalDateTime localDateTime = null;

        System.out.println("Enter date and time in format \"yyyy-MM-dd HH:mm\"");

        while (localDateTime == null) {
            String string = scanner.nextLine();
            localDateTime = ValidationUtil.parseDateTime(string);
        }
        return localDateTime;
    }

    /**
     * Read and validate string from console to int value.
     *
     * @return int representation of string.
     */
    public static int intValidationInput() {
        Integer parseInt = null;
        do {
            parseInt = ValidationUtil.parseInt(scanner.nextLine());
        } while (isNull(parseInt));
        return parseInt;
    }

    /**
     * Read and validate string from console to long value.
     *
     * @return long representation of string.
     */
    public static long longValidationInput() {
        Long parseLong = null;
        do {
            parseLong = ValidationUtil.parseLong(scanner.next());
        } while (isNull(parseLong));
        return parseLong;
    }

    /**
     * Read and validate string from console to double value.
     *
     * @return double representation of string.
     */
    public static double doubleValidationInput() {
        Double parseDouble = null;
        do {
            parseDouble = ValidationUtil.parseDouble(scanner.next());
        } while (isNull(parseDouble));
        return parseDouble;
    }

    /**
     * Read string from console and return it own.
     *
     * @return inputed string.
     */
    public static String stringValidationInput() {
        String string = null;
        do {
            string = scanner.nextLine();
        } while (Objects.equals(string, EMPTY_STING));
        return string;
    }
}
