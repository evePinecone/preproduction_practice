package com.epam.preprod.roman_lutsenko.task4.constants.containers;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.*;

import java.util.Map;
import java.util.TreeMap;

public class StrategyContainer {

    private Map<String, InputStrategy> strategyList = new TreeMap<>();

    {
        //Here put elements.
        strategyList.put("Desktop1", new AddWithKeyboardDesktopStrategy());
        strategyList.put("Laptop1", new AddWithKeyboardLaptopStrategy());
        strategyList.put("FitnessBracelet1", new AddWithKeyboardFitnessBraceletStrategy());
        strategyList.put("Desktop2", new AddWithRandomDesktopStrategy());
        strategyList.put("Laptop2", new AddWithRandomLaptopStrategy());
        strategyList.put("FitnessBracelet2", new AddWithRandomFitnessBraceletStrategy());
        strategyList.put("666", new NoSuchStrategy());
    }

    public InputStrategy getStrategy(String key) {
        if (strategyList.containsKey(key) && key != null) {
            return strategyList.get(key);
        }
        return strategyList.get("666");
    }
}
