package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input_reflection;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputReflectionStrategy;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

public class NoSuchReflectionStrategy implements InputReflectionStrategy {
    @Override
    public void build(Thing thing, Context context) {
        System.err.println("No such strategie");
    }
}
