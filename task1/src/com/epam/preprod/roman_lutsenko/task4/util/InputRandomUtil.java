package com.epam.preprod.roman_lutsenko.task4.util;

public class InputRandomUtil {

    public static int getRandomInt() {
        return (int) (Math.random() * 10000 + 1000);
    }

    public static long getRandomLong() {
        return (long) (Math.random() * 10000 + 1000);
    }

    public static double getRandomDouble() {
        return (double) (Math.random() * 10000 + 1000);
    }

    public static double getRandomDouble(double rangeWidth, double lowBorder) {
        return (double) (Math.random() * rangeWidth + lowBorder);
    }

}
