package com.epam.preprod.roman_lutsenko.task4.constants.containers;

import com.epam.preprod.roman_lutsenko.task1.entity.*;

import java.util.Map;
import java.util.TreeMap;

public class EntityContainer {

    private Map<String, Thing> strategyList = new TreeMap<>();

    {
        //Here put elements.
        strategyList.put("1", new Laptop());
        strategyList.put("2", new Desktop());
        strategyList.put("3", new FitnessBracelet());
        strategyList.put("666", new NoSuchEntity());
    }

    public Thing getEntity(String key) {
        if (strategyList.containsKey(key) && key != null) {
            return strategyList.get(key);
        }
        return strategyList.get("666");
    }

    public static void show() {
        System.out.println("1. Laptop");
        System.out.println("2. Desktop");
        System.out.println("3. FitnessBracelet");
    }
}
