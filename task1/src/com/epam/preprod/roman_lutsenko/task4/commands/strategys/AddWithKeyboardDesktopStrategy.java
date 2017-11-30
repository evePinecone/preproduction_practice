package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

/**
 * Setting with keyboard fields of element specified by type Desktop.
 *
 * @param <T>
 */
public class AddWithKeyboardDesktopStrategy<T extends Desktop>
        extends AddWithKeyboardComputerStrategy<T> {

    @Override
    public T input(T thing) {
        super.input(thing);
        System.out.println("Enter form factor ");
        thing.setFormFactor(InputUtil.stringValidationInput());

        System.out.println("Enter type workspace ");
        thing.setTypeWorkspace(InputUtil.stringValidationInput());
        return thing;
    }
}

