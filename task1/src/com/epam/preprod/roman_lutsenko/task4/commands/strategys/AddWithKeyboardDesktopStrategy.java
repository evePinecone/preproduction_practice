package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardDesktopStrategy implements InputStrategy<Desktop> {

    @Override
    public Desktop input(Desktop thing) {

        System.out.println("Enter Id > ");
        thing.setId(InputUtil.intValidationInput());

        System.out.println("Enter nameModel ");
        thing.setNameModel(InputUtil.stringValidationInput());

        System.out.println("Enter price ");
        thing.setPrice(InputUtil.longValidationInput());

        System.out.println("Enter processors name ");
        thing.setNameProcessor(InputUtil.stringValidationInput());

        System.out.println("Enter RAM ");
        thing.setRAM(InputUtil.intValidationInput());

        System.out.println("Enter form factor ");
        thing.setFormFactor(InputUtil.stringValidationInput());

        System.out.println("Enter type workspace ");
        thing.setTypeWorkspace(InputUtil.stringValidationInput());
        return thing;
    }
}

