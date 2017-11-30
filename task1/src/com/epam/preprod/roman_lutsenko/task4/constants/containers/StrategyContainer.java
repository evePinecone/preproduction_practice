package com.epam.preprod.roman_lutsenko.task4.constants.containers;

import com.epam.preprod.roman_lutsenko.task4.commands.strategys.AddWithKeyboardDesktopStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.AddWithKeyboardFitnessBraceletStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.AddWithKeyboardLaptopStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.AddWithRandomDesktopStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.AddWithRandomFitnessBraceletStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.AddWithRandomLaptopStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.NoSuchStrategy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Container for all strategies specified with type plus index of type strategy.
 * <b>1</b> - Keyboard strategy.
 * <b>2</b> - Random strategy.
 */
public class StrategyContainer {


    private static final String STRATEGY_KEYBOARD_DESKTOP = "Desktop1";
    private static final String STRATEGY_KEYBOARD_LAPTOP = "Laptop1";
    private static final String STRATEGY_KEYBOARD_FITNESS_BRACELET = "FitnessBracelet1";
    private static final String STRATEGY_RANDOM_DESKTOP = "Desktop2";
    private static final String STRATEGY_RANDOM_LAPTOP = "Laptop2";
    private static final String STRATEGY_RANDOM_FITNESS_BRACELET = "FitnessBracelet2";
    private static final String STRATEGY_NO_SUCH_STRATEGY = "noSuchStrategy";

    private Map<String, InputStrategy> strategyList = new TreeMap<>();

    public StrategyContainer() {
        //Here put elements.
        strategyList.put(STRATEGY_KEYBOARD_DESKTOP, new AddWithKeyboardDesktopStrategy());
        strategyList.put(STRATEGY_KEYBOARD_LAPTOP, new AddWithKeyboardLaptopStrategy());
        strategyList.put(STRATEGY_KEYBOARD_FITNESS_BRACELET, new AddWithKeyboardFitnessBraceletStrategy());
        strategyList.put(STRATEGY_RANDOM_DESKTOP, new AddWithRandomDesktopStrategy());
        strategyList.put(STRATEGY_RANDOM_LAPTOP, new AddWithRandomLaptopStrategy());
        strategyList.put(STRATEGY_RANDOM_FITNESS_BRACELET, new AddWithRandomFitnessBraceletStrategy());
        strategyList.put(STRATEGY_NO_SUCH_STRATEGY, new NoSuchStrategy());
    }

    public InputStrategy getStrategy(String key) {
        if (strategyList.containsKey(key) && key != null) {
            return strategyList.get(key);
        }
        return strategyList.get("noSuchStrategy");
    }
}
