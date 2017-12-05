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
import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR_END;

public class LongSequence extends Thread {

    private Buffer buffer;

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
            byte[] bytes = getBytesFromFile(buffer.getFile().getName());
            Byte[] bytesWrapper = bytesToWrapper(bytes);
            List<Byte> listByte = getBiggestSequence(bytesWrapper);
            synchronized (MONITOR_END) {
                try {
                    MONITOR_END.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buffer.clear();
            }
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

    private List<Byte> getBiggestSequence(Byte[] bytes) {
        List<Byte> baseListByte = convertBytesToList(bytes);
        Map<List<Byte>, Integer> resultContainer = new HashMap<>();
        for (int i = baseListByte.size(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                List<Byte> subListByte = baseListByte.subList(j, i);
                if (resultContainer.containsKey(subListByte)) {
                    buffer.setResult(convertListBytesToArr(subListByte), j, resultContainer.get(subListByte));
                    return subListByte;
                }
                resultContainer.put(subListByte, j);
                // System.err.println(subListByte);
                buffer.setResultBytes(convertListBytesToArr(subListByte));
            }
        }
        return new ArrayList<>();
    }

    private List<Byte> convertBytesToList(Byte[] bytes) {
        //Uncomment to work.
//        List byteList = Arrays.asList(bytes);
        Byte[] byteqwe = new Byte[]{1, 2, 1, 2, 1, 2};
        List byteList = Arrays.asList(byteqwe);
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

    public static Byte[] bytesToWrapper(byte[] bytes) {
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
