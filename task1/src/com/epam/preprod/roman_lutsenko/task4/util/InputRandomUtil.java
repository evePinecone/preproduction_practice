package com.epam.preprod.roman_lutsenko.task4.util;

/**
 * Class contains input with random methods for different types of data.
 */
public final class InputRandomUtil {


    private static final int RANDOM_DELTA_NUMBER = 10000;
    private static final int RANDOM_LOWER_THRESHOLD_NUMBER = 1000;

    /**
     * Blocked constructor.
     */
    private InputRandomUtil() {
    }

    /**
     * Returns random int number.
     *
     * @return int random number in range RANDOM_LOWER_THRESHOLD_NUMBER with delta = RANDOM_DELTA_NUMBER.
     */
    public static int getRandomInt() {
        return (int) (Math.random() * RANDOM_DELTA_NUMBER + RANDOM_LOWER_THRESHOLD_NUMBER);
    }

    /**
     * Returns random long number.
     *
     * @return long random number in range RANDOM_LOWER_THRESHOLD_NUMBER with delta = RANDOM_DELTA_NUMBER.
     */
    public static long getRandomLong() {
        return (long) (Math.random() * RANDOM_DELTA_NUMBER + RANDOM_LOWER_THRESHOLD_NUMBER);
    }

    /**
     * Returns random double number.
     *
     * @return double random number in range RANDOM_LOWER_THRESHOLD_NUMBER with delta = RANDOM_DELTA_NUMBER.
     */
    public static double getRandomDouble() {
        return (double) (Math.random() * RANDOM_DELTA_NUMBER + RANDOM_LOWER_THRESHOLD_NUMBER);
    }

    /**
     * Returns double format number from range RANDOM_LOWER_THRESHOLD_NUMBER - low border and with delta = RANDOM_DELTA_NUMBER.
     *
     * @param rangeWidth delta of the range.
     * @param lowBorder  low border of double number.
     * @return double random number.
     */
    public static double getRandomDouble(double rangeWidth, double lowBorder) {
        return (double) (Math.random() * rangeWidth + lowBorder);
    }

    public static String getString() {
        return "string" + getRandomInt();
    }

}
