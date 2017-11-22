package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

public abstract class AddWithKeyboardPortableGadgetStrategy extends AddWithKeyboardThingStrategy{

    public void inputPortableGadget(PortableGadget thing) {
        inputThing(thing);
        System.out.println("Enter autonomy ");
        thing.setAutonomy(InputUtil.stringValidationInput());

      //  return thing;
    }
}
