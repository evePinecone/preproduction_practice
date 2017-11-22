package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;

public abstract class AddWithRandomComputerStrategy extends AddWithRandomThingStrategy {
    public Computer inputComputer(Computer thing) {
        inputThing(thing);
        thing.setRAM((int)(Math.random() * 5000 + 1000));
        thing.setNameProcessor("processor" + (int)(Math.random() * 10000 + 1000));
        return thing;
    }
}
