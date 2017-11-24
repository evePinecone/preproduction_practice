package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

public abstract class AddWithKeyboardPortableGadgetStrategy<T extends PortableGadget> extends AddWithKeyboardThingStrategy<T>{

    @Override
    public T input(T thing) {
        super.input(thing);
        System.out.println("Enter autonomy ");
        thing.setAutonomy(InputUtil.stringValidationInput());
        return thing;
    }
}
