package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type Computer.
 *
 * @param <T>
 */
public abstract class AddWithRandomComputerStrategy<T extends Computer> extends AddWithRandomThingStrategy<T> {

    public T input(T thing) {
        super.input(thing);
        final String PROCESSORS_FIELD = "processor" + InputRandomUtil.getRandomInt();
        thing.setRAM(InputRandomUtil.getRandomInt());
        thing.setNameProcessor(PROCESSORS_FIELD);
        return thing;
    }
}
