package com.epam.preprod.roman_lutsenko.task8.primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class FindPrimes {

    private List<Integer> arrayOfPrimes;
    private final int numberOfThreads;
    private final int lowBorder;
    private final int highBorder;
    private Queue<Integer> queue;

    public FindPrimes(int numberOfThreads, int lowBorder, int highBorder) {
        this.numberOfThreads = numberOfThreads;
        this.lowBorder = lowBorder;
        this.highBorder = highBorder;
        arrayOfPrimes = Collections.synchronizedList(new ArrayList<>());
        queue = new LinkedTransferQueue<>();
        setQueueWithAllDeltaPrimes();
    }

    public void findPrimes() {
        List <Thread> list = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                while (!queue.isEmpty()) {
                    Integer element = queue.poll();
                    int halfOfElement = element / 2;
                    boolean isNotPrimeNumber = false;
                    for (int i1 = 2; i1 <= halfOfElement; i1++) {
                        if (element % i1 == 0) {
                            isNotPrimeNumber = true;
                            break;
                        }
                    }
                    if (!isNotPrimeNumber) {
                        arrayOfPrimes.add(element);
                    }
                }
            });
            thread.start();
            list.add(thread);
        };
        //в метод и поставить таймер 10мс
        for (Thread thread : list) {
            while(thread.isAlive());
        }
    }

    private void setQueueWithAllDeltaPrimes() {
        Integer[] integers = new Integer[highBorder - lowBorder];
        for (int i = lowBorder, k = 0; i <= highBorder; i++, k++) {
            queue.add(i);
        }
    }

    public List<Integer> getArrayOfPrimes() {
        Collections.sort(arrayOfPrimes);
        return arrayOfPrimes;
    }

}
