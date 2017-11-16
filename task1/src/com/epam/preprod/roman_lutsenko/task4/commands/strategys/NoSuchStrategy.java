package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public class NoSuchStrategy implements InputStrategy {

    @Override
    public Thing input(Thing thing) {
        System.out.println("Incorrect command, gl hf");
        return null;
    }
}
