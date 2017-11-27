package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

/**
 * Setting with keyboard fields of element specified by type Computer.
 *
 * @param <T>
 */
public abstract class AddWithKeyboardComputerStrategy<T extends Computer>
        extends AddWithKeyboardThingStrategy<T> {

    @Override
    public T input(T thing) {
        super.input(thing);
        System.out.println("Enter processors name ");
        thing.setNameProcessor(InputUtil.stringValidationInput());

        System.out.println("Enter RAM ");
        thing.setRAM(InputUtil.intValidationInput());

        return thing;
    }

}
