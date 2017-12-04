package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR;

public class LongSequence extends Thread {

    private Buffer buffer;

    public LongSequence(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (Objects.isNull(buffer.getFile())) {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted waiting in LongSequence.class");
                }
            }
        }
        byte[] bytes = getBytesFromFile(buffer.getFile().getName());
        getMapWithSequences(bytes);
    }

    private byte[] getBytesFromFile(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<Byte[], Integer> getMapWithSequences(byte[] bytes1) {
        Map<Byte[], Integer> map = new HashMap<>();
        Byte [] bytes = new Byte[]{1, 2, 1,2};
        for (int outer = 0; outer < bytes.length; outer++) {
            for (int i = outer+1; i <= bytes.length; i++) {
                Byte[] bufBytes = Arrays.copyOfRange(bytes, outer, i);
                for (Byte bufByte : bufBytes) {
                    System.out.print(bufByte);
                }
                System.out.println();
                if (map.containsKey(bufBytes)) {
                    map.put(bufBytes, map.get(bufBytes) + 1);
                  //  if(Objects.nonNull(buffer.getResultBytes()) && buffer.getResultBytes().length < bufBytes.length) {
                        buffer.setResultBytes(bufBytes);
                   // }
                } else {
                    map.put(bufBytes, 0);
                }
            }
        }
        return map;
    }
    /*
    1
    12
    121
    1212
    2
    21
    212
    1
    12
    2
     */
}
