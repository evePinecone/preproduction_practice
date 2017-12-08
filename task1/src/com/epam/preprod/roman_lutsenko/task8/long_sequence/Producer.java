package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.File;
import java.util.Scanner;

/**
 * Initiation of finding algorithm.
 * Produces output final result and intermediate result while thread Buffer works.
 */
public class Producer extends Thread {
    public static final Object MONITOR = new Object();
    public static final Object MONITOR_SETTED = new Object();
    public static final Object MONITOR_END = new Object();

    private final Buffer buffer;

    /**
     * Start of searcher program.
     *
     * @param args is null.
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        LongSequence longSequence = new LongSequence(buffer);
        Producer producer = new Producer(buffer);
        longSequence.start();
        producer.start();
    }

    /**
     * Set the Buffer element to classes.
     * Must be one object that is added to LongSequence.
     *
     * @param buffer buffer object with which threads are communicated.
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            File file = null;
            System.out.println("Enter file name");
            while (file == null || !file.isFile()) {
                String fileName = scanner.nextLine();
                file = new File(fileName);
            }
            buffer.setFile(file);

            while (!buffer.isEnd()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MONITOR_SETTED) {
                    System.out.println("Length of processed sequence " + buffer.getResult().length);
                }
            }
            synchronized (MONITOR_END) {
                System.out.println("find result");
                for (Byte aByte : buffer.getResult()) {
                    System.out.print(aByte + " ");
                }
                System.out.println("\nIndex of first injection = " + buffer.getFirstIndexInjection());
                System.out.println("Index of last injection = " + buffer.getSecondIndexInjection());
                MONITOR_END.notifyAll();
            }
        }
    }

}
