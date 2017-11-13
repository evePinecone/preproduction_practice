package com.epam.preprod.roman_lutsenko.task3;

import com.epam.preprod.roman_lutsenko.task1.entity.*;
import com.epam.preprod.roman_lutsenko.task3.wrapper.StringFourHashWrapper;
import com.epam.preprod.roman_lutsenko.task3.wrapper.StringLengthHashWrapper;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DemoWrappers {

    private HashMap<StringLengthHashWrapper, Thing> hashMapLengKey;
    private HashMap<StringFourHashWrapper, Thing> hashMapFourKey;
    private LinkedHashMap<StringLengthHashWrapper, Thing> linkedHashMapLengKey;
    private LinkedHashMap<StringFourHashWrapper, Thing> linkedHashMapFourKey;

    private void init() {
        hashMapLengKey = new HashMap<>();

        hashMapLengKey.put(new StringLengthHashWrapper("1"), new Laptop());
        hashMapLengKey.put(new StringLengthHashWrapper("2"), new Desktop());
        hashMapLengKey.put(new StringLengthHashWrapper("3"), new Computer());
        hashMapLengKey.put(new StringLengthHashWrapper("4"), new FitnessBraslet());

        linkedHashMapLengKey = new LinkedHashMap<>();

        linkedHashMapLengKey.put(new StringLengthHashWrapper("1"), new Laptop());
        linkedHashMapLengKey.put(new StringLengthHashWrapper("2"), new Desktop());
        linkedHashMapLengKey.put(new StringLengthHashWrapper("3"), new Computer());
        linkedHashMapLengKey.put(new StringLengthHashWrapper("4"), new FitnessBraslet());

        hashMapFourKey = new HashMap<>();

        hashMapFourKey.put(new StringFourHashWrapper("1111"), new Laptop());
        hashMapFourKey.put(new StringFourHashWrapper("2222"), new Desktop());
        hashMapFourKey.put(new StringFourHashWrapper("3333"), new Computer());
        hashMapFourKey.put(new StringFourHashWrapper("4444"), new FitnessBraslet());
        hashMapFourKey.put(new StringFourHashWrapper("5555"), new Computer());
        hashMapFourKey.put(new StringFourHashWrapper("6666"), new FitnessBraslet());

        linkedHashMapFourKey = new LinkedHashMap<>();

        linkedHashMapFourKey.put(new StringFourHashWrapper("1"), new Laptop());
        linkedHashMapFourKey.put(new StringFourHashWrapper("2"), new Desktop());
        linkedHashMapFourKey.put(new StringFourHashWrapper("3"), new Computer());
        linkedHashMapFourKey.put(new StringFourHashWrapper("4"), new FitnessBraslet());

    }

    private void showIteratedMap() {
        init();
        System.out.println("hashMapLengKey " + System.lineSeparator() +
                "________________________________");
        for (StringLengthHashWrapper key : hashMapLengKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + hashMapLengKey.get(key));
        }

        System.out.println(System.lineSeparator() + "______________________________" +
                System.lineSeparator() + "linkedHashMapLengKey " + System.lineSeparator() +
                "________________________________");
        for (StringLengthHashWrapper key : linkedHashMapLengKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + hashMapLengKey.get(key));
        }

        System.out.println(System.lineSeparator() + "______________________________" +
                System.lineSeparator() + "hashMapFourKey " + System.lineSeparator() +
                "________________________________");
        for (StringFourHashWrapper key : hashMapFourKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + hashMapFourKey.get(key));
        }

        System.out.println(System.lineSeparator() + "______________________________" +
                System.lineSeparator() + "linkedHashMapFourKey " + System.lineSeparator() +
                "________________________________");
        for (StringFourHashWrapper key : linkedHashMapFourKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + linkedHashMapFourKey.get(key));
        }

    }

    public static void main(String[] args) {
        new DemoWrappers().showIteratedMap();
    }
}
