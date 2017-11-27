package com.epam.preprod.roman_lutsenko.task4.controller;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.StrategyContainer;
import com.epam.preprod.roman_lutsenko.task4.context.StrategyContext;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

public class StrategyController {

    private StrategyContext strategyContext;

    public StrategyController() {
        this.strategyContext = new StrategyContext();
        showAndInstanceContext(strategyContext);
    }

    public StrategyContext getStrategyContext() {
        return strategyContext;
    }

    private void showAndInstanceContext(StrategyContext strategyContext) {
        String choice;
        StrategyContainer strategyContainer = new StrategyContainer();

        System.out.println("Desktop insert with ");
        showStrategyInput();
        choice = InputUtil.stringValidationInput();
        strategyContext.put(Desktop.class, strategyContainer.getStrategy("Desktop" + choice));

        System.out.println("Laptop insert with ");
        showStrategyInput();
        choice = InputUtil.stringValidationInput();
        strategyContext.put(Laptop.class, strategyContainer.getStrategy("Laptop" + choice));

        System.out.println("FitnessBracelet insert with ");
        showStrategyInput();
        choice = InputUtil.stringValidationInput();
        strategyContext.put(FitnessBracelet.class, strategyContainer.getStrategy("FitnessBracelet" + choice));

    }

    private void showStrategyInput() {
        System.out.println("\t1. Add with Keyboard");
        System.out.println("\t2. Add with Random");
    }
}
