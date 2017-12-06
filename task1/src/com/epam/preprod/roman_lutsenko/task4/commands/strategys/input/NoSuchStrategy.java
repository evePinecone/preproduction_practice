package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;

public class NoSuchStrategy implements InputStrategy {

    @Override
    public Thing input(Thing thing) {
        System.out.println("Incorrect strategy");
        return null;
    }
}
