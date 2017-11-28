package com.epam.preprod.roman_lutsenko.task7.commands.strategies;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task7.commands.InputReflectionStrategy;

public class NoSuchReflectionStrategy implements InputReflectionStrategy {
    @Override
    public void build(Thing thing, Context context) {
        System.err.println("No such strategie");
    }
}
