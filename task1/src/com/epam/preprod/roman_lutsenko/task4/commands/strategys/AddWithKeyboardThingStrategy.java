package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

/**
 * Setting with keyboard fields of element specified by type Thing.
 *
 * @param <T>
 */
public abstract class AddWithKeyboardThingStrategy<T extends Thing> implements InputStrategy<T> {

    public T input(T thing) {
        System.out.println("Enter Id > ");
        thing.setId(InputUtil.intValidationInput());

        System.out.println("Enter nameModel ");
        thing.setNameModel(InputUtil.stringValidationInput());

        System.out.println("Enter price ");
        thing.setPrice(InputUtil.longValidationInput());
        return thing;
    }
}
