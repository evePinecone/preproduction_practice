package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardLaptopStrategy implements InputStrategy <Laptop>{

    @Override
    public Laptop input(Laptop thing) {

       // super.input(thing);

        System.out.println("Enter displayResolution ");
        thing.setDisplayResolution(InputUtil.doubleValidationInput());

        System.out.println("Enter weight ");
        thing.setWeight(InputUtil.doubleValidationInput());

        return thing;
    }
}
