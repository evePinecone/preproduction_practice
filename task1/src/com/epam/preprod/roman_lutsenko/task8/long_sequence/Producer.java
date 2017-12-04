package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Producer extends Thread {
    public static final Object MONITOR = new Object();
    public static final Object MONITOR_SETTED = new Object();
    private final Buffer buffer;
    private static String PATH = "\\task1\\testTask5";

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        LongSequence longSequence = new LongSequence(buffer);
        Producer producer = new Producer(buffer);
        longSequence.start();
        producer.start();
    }

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName = scanner.nextLine();
        buffer.setFile(new File(PATH));
        while(Objects.isNull(buffer.result)) {
            synchronized (MONITOR_SETTED) {
                try {
                    MONITOR_SETTED.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Arrays.toString(buffer.getResultBytes()));
        }
    }
}
