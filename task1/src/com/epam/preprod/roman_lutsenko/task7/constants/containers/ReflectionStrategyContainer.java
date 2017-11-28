package com.epam.preprod.roman_lutsenko.task7.constants.containers;

import com.epam.preprod.roman_lutsenko.task7.commands.InputReflectionStrategy;
import com.epam.preprod.roman_lutsenko.task7.commands.strategies.InputKeyboardReflectionStrategy;
import com.epam.preprod.roman_lutsenko.task7.commands.strategies.InputRandomReflectionStrategy;
import com.epam.preprod.roman_lutsenko.task7.commands.strategies.NoSuchReflectionStrategy;

import java.util.Map;
import java.util.TreeMap;

import static com.epam.preprod.roman_lutsenko.task7.constants.ReflectionStrategyConstants.STRATEGY_ID_INPUT_KEYBOARD_REFLECTION;
import static com.epam.preprod.roman_lutsenko.task7.constants.ReflectionStrategyConstants.STRATEGY_ID_INPUT_RANDOM_REFLECTION;
import static com.epam.preprod.roman_lutsenko.task7.constants.ReflectionStrategyConstants.STRATEGY_ID_NO_SUCH_STRATEGY;

public class ReflectionStrategyContainer {
    private Map<String, InputReflectionStrategy> strategyMap = new TreeMap<>();

    public ReflectionStrategyContainer() {
        //Here put elements.
        strategyMap.put(STRATEGY_ID_INPUT_KEYBOARD_REFLECTION, new InputKeyboardReflectionStrategy());
        strategyMap.put(STRATEGY_ID_INPUT_RANDOM_REFLECTION, new InputRandomReflectionStrategy());
        strategyMap.put(STRATEGY_ID_NO_SUCH_STRATEGY, new NoSuchReflectionStrategy());

    }

    public InputReflectionStrategy getEntity(String key) {
        if (strategyMap.containsKey(key) && key != null) {
            return strategyMap.get(key);
        }
        return strategyMap.get(STRATEGY_ID_NO_SUCH_STRATEGY);
    }

    public static void show() {
        System.out.println("1. InputKeyboardReflectionStrategy()");
        System.out.println("2. InputRandomReflectionStrategy()");
    }
}
