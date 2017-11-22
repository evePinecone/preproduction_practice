package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

public abstract class AddWithKeyboardThingStrategy implements InputStrategy<Thing>{

    @Override
    public Thing input(Thing thing) {
        System.out.println("Enter Id > ");
        thing.setId(InputUtil.intValidationInput());

        System.out.println("Enter nameModel ");
        thing.setNameModel(InputUtil.stringValidationInput());

        System.out.println("Enter price ");
        thing.setPrice(InputUtil.longValidationInput());

        return thing;
    }
}
