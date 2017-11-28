package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.EntityContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputReflectionStrategy;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.ReflectionStrategyContainer;

public class AddThingWithReflectionCommand implements Command {


    @Override
    public void execute(Context context) {
        Thing thing = chooseThingToADD();
        InputReflectionStrategy inputReflectionStrategy = chooseInputReflectionStrategy();
        inputReflectionStrategy.build(thing, context);
        System.out.println(thing);
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

    private InputReflectionStrategy chooseInputReflectionStrategy() {
        ReflectionStrategyContainer.show();
        return new ReflectionStrategyContainer().getEntity(
                InputUtil.stringValidationInput());
    }
}
