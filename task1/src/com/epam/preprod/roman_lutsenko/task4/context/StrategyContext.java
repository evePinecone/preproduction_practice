package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyContext {

    private Map<Class, InputStrategy> strategyMap = new HashMap<>();

    public void put(Class clazz, InputStrategy inputStrategy) {
        strategyMap.put(clazz, inputStrategy);
    }

    public InputStrategy get(Class clazz) {
        return strategyMap.get(clazz);
    }

}
