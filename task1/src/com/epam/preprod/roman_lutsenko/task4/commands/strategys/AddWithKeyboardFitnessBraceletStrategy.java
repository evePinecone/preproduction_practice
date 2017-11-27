package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

/**
 * Setting with keyboard fields of element specified by type Laptop.
 * @param <T>
 */
public class AddWithKeyboardFitnessBraceletStrategy<T extends FitnessBracelet> extends AddWithKeyboardPortableGadgetStrategy<T> {

    @Override
    public T input(T thing) {
        super.input(thing);

        System.out.println("Enter display type ");
        thing.setDisplay(InputUtil.stringValidationInput());

        System.out.println("Enter strapMaterial ");
        thing.setStrapMaterial(InputUtil.stringValidationInput());
        return thing;
    }
}
