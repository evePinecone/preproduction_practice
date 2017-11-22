package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardDesktopStrategy extends  AddWithKeyboardComputerStrategy implements InputStrategy<Desktop> {

    @Override
    public Desktop input(Desktop thing) {
        inputComputer(thing);
        System.out.println("Enter form factor ");
        thing.setFormFactor(InputUtil.stringValidationInput());

        System.out.println("Enter type workspace ");
        thing.setTypeWorkspace(InputUtil.stringValidationInput());
        return thing;
    }
}

