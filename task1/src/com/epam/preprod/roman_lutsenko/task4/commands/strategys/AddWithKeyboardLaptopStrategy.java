package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardLaptopStrategy implements InputStrategy<Laptop> {

    @Override
    public Laptop input(Laptop thing) {

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

        System.out.println("Enter displayResolution ");
        thing.setDisplayResolution(InputUtil.doubleValidationInput());

        System.out.println("Enter weight ");
        thing.setWeight(InputUtil.doubleValidationInput());

        return thing;
    }
}
