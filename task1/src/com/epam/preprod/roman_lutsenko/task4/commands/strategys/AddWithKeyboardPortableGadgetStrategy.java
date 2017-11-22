package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

public abstract class AddWithKeyboardPortableGadgetStrategy implements InputStrategy<PortableGadget>{

    @Override
    public PortableGadget input(PortableGadget thing) {

        System.out.println("Enter autonomy ");
        thing.setAutonomy(InputUtil.stringValidationInput());

        return thing;
    }
}
