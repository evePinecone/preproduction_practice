package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;

public abstract class AddWithRandomComputerStrategy implements InputStrategy<Computer> {
    @Override
    public Computer input(Computer thing) {
        thing.setPrice((long)(Math.random() * 10000 + 1000));
        thing.setNameProcessor("processor" + (int)(Math.random() * 10000 + 1000));
        return thing;
    }
}
