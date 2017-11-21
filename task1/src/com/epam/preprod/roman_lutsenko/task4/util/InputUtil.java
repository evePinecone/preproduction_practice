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

    public static String stringValidationInput() {
        return scanner.nextLine();
    }
}

