package com.epam.preprod.roman_lutsenko.task8.primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Find prime numbers with using Executor and it service.
 */
public class FindPrimesExecutor {

    private List<Integer> arrayOfPrimes;
    private final int numberOfThreads;
    private final int lowBorder;
    private final int highBorder;
    private Queue<Integer> queue;

    /**
     * Constructor to create an instance of FindPrimesExecutor.
     *
     * @param numberOfThreads numberOfThread with which algorithm will work.
     * @param lowBorder       lowest number from which searching will start.
     * @param highBorder      to which searching will go.
     */
    public FindPrimesExecutor(int numberOfThreads, int lowBorder, int highBorder) {
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
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
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
            executorService.execute(thread);
        }
        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(10, TimeUnit.MILLISECONDS)) {
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting");
        }
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

}
