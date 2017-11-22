package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

public abstract class AddWithKeyboardComputerStrategy extends AddWithKeyboardThingStrategy {

    public Computer input(Computer thing) {
       // super.input(thing);
        System.out.println("Enter processors name ");
        thing.setNameProcessor(InputUtil.stringValidationInput());

        System.out.println("Enter RAM ");
        thing.setRAM(InputUtil.intValidationInput());

        return thing;
    }
}
