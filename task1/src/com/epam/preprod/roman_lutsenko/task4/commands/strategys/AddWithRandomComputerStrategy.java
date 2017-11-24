package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

public abstract class AddWithRandomComputerStrategy<T extends Computer> extends AddWithRandomThingStrategy<T> {
    private final String PROCESSORS_FIELD = "processor" + InputRandomUtil.getRandomInt();

    public T input(T thing) {
        super.input(thing);
        thing.setRAM(InputRandomUtil.getRandomInt());
        thing.setNameProcessor(PROCESSORS_FIELD);
        return thing;
    }
}
