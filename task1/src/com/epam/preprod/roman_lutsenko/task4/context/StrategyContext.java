package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Instance of object contains creation strategies for specified things.
 */
public class StrategyContext {

    /**
     * Container for strategies.
     */
    private Map<Class, InputStrategy> strategyMap = new HashMap<>();

    /**
     * Put specified strategy input for elements.
     * @param clazz key in map = type of element for specified strategy.
     * @param inputStrategy strategy to input element with type <b>clazz</b>
     */
    public void put(Class clazz, InputStrategy inputStrategy) {
        strategyMap.put(clazz, inputStrategy);
    }

    /**
     * Return specified strategy for type <b>clazz</b>
     * @param clazz type of element for returning the correct strategy
     * @return correct strategy.
     */
    public InputStrategy get(Class clazz) {
        return strategyMap.get(clazz);
    }

}
