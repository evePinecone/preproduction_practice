package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;

import java.util.Scanner;

public class AddWithRandomLaptopStrategy implements InputStrategy<Laptop> {

    @Override
    public Laptop input(Laptop thing) {
        int id = (int)(Math.random()*10000+1000);
        thing.setId(id);
        thing.setNameModel("Laptop" + id);
        thing.setPrice((long)(Math.random() * 10000 + 1000));
        thing.setNameProcessor("processor" + id);
        thing.setRAM((int)(Math.random() * 5000 + 1000));
        thing.setDisplayResolution(Math.random() * 8 + 12);
        thing.setWeight(Math.random() * 2 + 0.5);
        return thing;
    }
}
