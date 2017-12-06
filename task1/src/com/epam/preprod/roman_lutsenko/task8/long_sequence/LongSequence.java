package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR;

/**
 * Contains algorithm of searching and notify Producer about it progress by buffer sync.
 */
public class LongSequence extends Thread {

    private Buffer buffer;

    /**
     * Set the Buffer element to classes.
     * Must be one object that is added to Producer.
     *
     * @param buffer buffer object with which threads are communicated.
     */
    public LongSequence(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            while (Objects.isNull(buffer.getFile())) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted waiting in LongSequence.class");
                    }
                }
            }
            byte[] bytes = getBytesFromFile(buffer.getFile().getAbsolutePath());
            Byte[] bytesWrapper = bytesToWrapper(bytes);
            getBiggestSequence(bytesWrapper);
            buffer.clear();
        }
    }

    private byte[] getBytesFromFile(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void getBiggestSequence(Byte[] bytes) {
        List<Byte> baseListByte = convertBytesToList(bytes);
        Map<List<Byte>, Integer> resultContainer = new HashMap<>();
        for (int i = baseListByte.size(); i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                List<Byte> subListByte = baseListByte.subList(j, i);
                if (resultContainer.containsKey(subListByte) && buffer.getResult().length < subListByte.size()) {
                    buffer.setResult(convertListBytesToArr(subListByte), j, resultContainer.get(subListByte));
                } else {
                    resultContainer.put(subListByte, j);
                }
            }
        }
        buffer.setEnd(true);
    }

    private List<Byte> convertBytesToList(Byte[] bytes) {
        List byteList = Arrays.asList(bytes);
        return new ArrayList<>(byteList);
    }

    private Byte[] convertListBytesToArr(List<Byte> list) {
        if (Objects.isNull(list)) {
            return new Byte[]{};
        }
        Byte[] bytes = new Byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    private static Byte[] bytesToWrapper(byte[] bytes) {
        if (Objects.isNull(bytes)) {
            return null;
        }
        Byte[] bytesResult = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            bytesResult[i] = bytes[i];
        }
        return bytesResult;
    }
}
