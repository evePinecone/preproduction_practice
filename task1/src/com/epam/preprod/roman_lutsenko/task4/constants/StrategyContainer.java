package com.epam.preprod.roman_lutsenko.task4.constants;

import com.epam.preprod.roman_lutsenko.task4.commands.strategys.*;

import java.util.Map;
import java.util.TreeMap;

public class StrategyContainer {

    private Map<String, InputStrategy> strategyList = new TreeMap<>();

    {
        //Here put elements.
        strategyList.put("1", new AddWithKeyboardDesktopStrategy());
        strategyList.put("2", new AddWithKeyboardLaptopStrategy());
        strategyList.put("3", new AddWithKeyboardFitnessBraceletStrategy());
        strategyList.put("4", new AddWithRandomDesktopStrategy());
        strategyList.put("5", new AddWithRandomLaptopStrategy());
        strategyList.put("6", new AddWithRandomFitnessBraceletStrategy());
        strategyList.put("666", new NoSuchStrategy());
    }

    public InputStrategy getStrategy(String key) {
        if (strategyList.containsKey(key) && key != null) {
            return strategyList.get(key);
        }
        return strategyList.get("666");
    }

    public static void showStrategyInput() {
        System.out.println("1. AddWithKeyboardDesktopStrategy.");
        System.out.println("2. AddWithKeyboardLaptopStrategy.");
        System.out.println("3. AddWithKeyboardFitnessBraceletStrategy.");
        System.out.println("4. AddWithRandomDesktopStrategy.");
        System.out.println("5. AddWithRandomLaptopStrategy.");
        System.out.println("6. AddWithRandomFitnessBraceletStrategy.");


    }
}
