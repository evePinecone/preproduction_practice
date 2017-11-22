package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;

import java.util.Scanner;

public class AddWithRandomLaptopStrategy extends AddWithRandomComputerStrategy implements InputStrategy<Laptop> {

    @Override
    public Laptop input(Laptop thing) {

        inputComputer(thing);
        thing.setDisplayResolution(Math.random() * 8 + 12);
        thing.setWeight(Math.random() * 2 + 0.5);
        return thing;
    }
}
