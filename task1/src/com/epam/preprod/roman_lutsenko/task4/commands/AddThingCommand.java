package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.EntityContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.context.StrategyContext;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

/**
 * Add specified type element to the catalog with setted strategy.
 * Strategies established at the beginning of program.
 */
public class AddThingCommand implements Command {

    @Override
    public void execute(Context context) {
        StrategyContext strategyContext = context.getStrategyContext();

        Thing thing = chooseThingToADD();
        InputStrategy inputStrategy = strategyContext.get(thing.getClass());
        inputStrategy.input(thing);
        context.getLocalProductService().put(thing);
    }

    /**
     * Shows available element to add, and return chosen element.
     *
     * @return chosen element.
     */
    private Thing chooseThingToADD() {
        EntityContainer.show();
        return new EntityContainer().getEntity(
                InputUtil.stringValidationInput());
    }

}
