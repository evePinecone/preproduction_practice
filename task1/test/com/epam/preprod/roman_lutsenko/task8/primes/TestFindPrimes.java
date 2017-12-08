package com.epam.preprod.roman_lutsenko.task8.primes;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestFindPrimes {
    static int n = 10000;
    static boolean[] primes = new boolean[n + 1];

    @BeforeClass
    public static void fillSieve() {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
    }

    @Test
    public void equalsArrayWithTwoMethods() throws InterruptedException {
        FindPrimes findPrimes = new FindPrimes(1, 2, 10000);
        findPrimes.findPrimes();
        Thread thread = new Thread() {
            @Override
            public void run() {

            }
        };
        thread.run();
        thread.join();
        List<Integer> list = findPrimes.getArrayOfPrimes();
        List<Integer> listBasePrimes = new ArrayList<>();
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                listBasePrimes.add(i);
            }
        }
        System.out.println(listBasePrimes);
        System.out.println(list);

        assertEquals(list, listBasePrimes);
    }
}
