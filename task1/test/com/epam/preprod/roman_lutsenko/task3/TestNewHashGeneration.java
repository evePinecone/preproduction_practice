package com.epam.preprod.roman_lutsenko.task3;

import com.epam.preprod.roman_lutsenko.task1.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestNewHashGeneration {

    private HashMap<StringLengHashWrapper, Thing> hashMapLengKey;
    private HashMap<StringFourHashWrapper, Thing> hashMapFourKey;
    private LinkedHashMap<StringLengHashWrapper, Thing> linkedHashMapLengKey;
    private LinkedHashMap<StringFourHashWrapper, Thing> linkedHashMapFourKey;

    @Before
    public void init() {
        hashMapLengKey = new HashMap<>();

        hashMapLengKey.put(new StringLengHashWrapper("1"), new Laptop());
        hashMapLengKey.put(new StringLengHashWrapper("2"), new Desktop());
        hashMapLengKey.put(new StringLengHashWrapper("3"), new Computer());
        hashMapLengKey.put(new StringLengHashWrapper("4"), new FitnessBracelet());

        linkedHashMapLengKey = new LinkedHashMap<>();

        linkedHashMapLengKey.put(new StringLengHashWrapper("1"), new Laptop());
        linkedHashMapLengKey.put(new StringLengHashWrapper("2"), new Desktop());
        linkedHashMapLengKey.put(new StringLengHashWrapper("3"), new Computer());
        linkedHashMapLengKey.put(new StringLengHashWrapper("4"), new FitnessBracelet());

        hashMapFourKey = new HashMap<>();

        hashMapFourKey.put(new StringFourHashWrapper("1111"), new Laptop());
        hashMapFourKey.put(new StringFourHashWrapper("2222"), new Desktop());
        hashMapFourKey.put(new StringFourHashWrapper("3333"), new Computer());
        hashMapFourKey.put(new StringFourHashWrapper("4444"), new FitnessBracelet());
        hashMapFourKey.put(new StringFourHashWrapper("5555"), new Computer());
        hashMapFourKey.put(new StringFourHashWrapper("6666"), new FitnessBracelet());

        linkedHashMapFourKey = new LinkedHashMap<>();

        linkedHashMapFourKey.put(new StringFourHashWrapper("1"), new Laptop());
        linkedHashMapFourKey.put(new StringFourHashWrapper("2"), new Desktop());
        linkedHashMapFourKey.put(new StringFourHashWrapper("3"), new Computer());
        linkedHashMapFourKey.put(new StringFourHashWrapper("4"), new FitnessBracelet());

    }

    @Test
    public void showIteratedMap() {
        System.out.println("hashMapLengKey \n________________________________");
        for (StringLengHashWrapper key : hashMapLengKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + hashMapLengKey.get(key));
        }

        System.out.println("\n______________________________\nlinkedHashMapLengKey \n________________________________");
        for (StringLengHashWrapper key : linkedHashMapLengKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + hashMapLengKey.get(key));
        }

        System.out.println("\n______________________________\nhashMapFourKey \n________________________________");
        for (StringFourHashWrapper key : hashMapFourKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + hashMapFourKey.get(key));
        }

        System.out.println("\n______________________________\nlinkedHashMapFourKey \n________________________________");
        for (StringFourHashWrapper key : linkedHashMapFourKey.keySet()) {
            System.out.println(key.getStringToHash() + " " + linkedHashMapFourKey.get(key));
        }

    }
}
