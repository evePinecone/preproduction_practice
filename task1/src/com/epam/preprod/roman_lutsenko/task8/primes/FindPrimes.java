package com.epam.preprod.roman_lutsenko.task8.primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Find prime numbers with simple Thread usage.
 */
public class FindPrimes {

    private List<Integer> arrayOfPrimes;
    private final int numberOfThreads;
    private final int lowBorder;
    private final int highBorder;
    private Queue<Integer> queue;

    /**
     * Constructor to create an instance of FindPrimes.
     *
     * @param numberOfThreads numberOfThread with which algorithm will work.
     * @param lowBorder       lowest number from which searching will start.
     * @param highBorder      to which searching will go.
     */
    public FindPrimes(int numberOfThreads, int lowBorder, int highBorder) {
        this.numberOfThreads = numberOfThreads;
        this.lowBorder = lowBorder;
        this.highBorder = highBorder;
        arrayOfPrimes = Collections.synchronizedList(new ArrayList<>());
        queue = new LinkedTransferQueue<>();
        setQueueWithAllDeltaPrimes();
    }

    /**
     * Fills up arrayOfPrimes with prime numbers in <b>numberOfThreads</b> threads.
     */
    public void findPrimes() {
        List<Thread> list = new ArrayList<>();
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
        }
        ;
        waitingAllThreads(list);
    }

    private void setQueueWithAllDeltaPrimes() {
        Integer[] integers = new Integer[highBorder - lowBorder];
        for (int i = lowBorder, k = 0; i <= highBorder; i++, k++) {
            queue.add(i);
        }
    }

    /**
     * Returns arrayOfPrimes.
     *
     * @return integer list of prime numbers.
     */
    public List<Integer> getArrayOfPrimes() {
        Collections.sort(arrayOfPrimes);
        return arrayOfPrimes;
    }

    private void waitingAllThreads(List<Thread> list) {
        for (Thread thread : list) {
            while (thread.isAlive()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
