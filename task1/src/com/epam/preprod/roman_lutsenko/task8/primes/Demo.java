package com.epam.preprod.roman_lutsenko.task8.primes;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSystemThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Enter low border and high border of primes number > ");
        int lowBorder = scanner.nextInt();
        int highBorder = scanner.nextInt();
        System.out.println("Enter number of threads > ");
        int numberOfThreads = scanner.nextInt();

        FindPrimes findPrimes = new FindPrimes(numberOfThreads, lowBorder, highBorder);
        findPrimes.findPrimes();

        System.out.println(findPrimes.getArrayOfPrimes());
    }
}
