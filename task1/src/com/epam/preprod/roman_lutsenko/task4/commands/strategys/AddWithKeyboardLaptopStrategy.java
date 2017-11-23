package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Computer;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardLaptopStrategy<T extends Laptop> extends AddWithKeyboardComputerStrategy<T>{

    @Override
    public T input(T thing) {
        super.input(thing);

        System.out.println("Enter displayResolution ");
        thing.setDisplayResolution(InputUtil.doubleValidationInput());

        System.out.println("Enter weight ");
        thing.setWeight(InputUtil.doubleValidationInput());

        return thing;
    }
}
