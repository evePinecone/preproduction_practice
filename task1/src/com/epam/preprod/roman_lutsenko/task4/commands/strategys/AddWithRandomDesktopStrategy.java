package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;

import java.util.Scanner;

public class AddWithRandomDesktopStrategy extends AddWithRandomComputerStrategy implements InputStrategy<Desktop>{

    @Override
    public Desktop input(Desktop thing) {
        int id = (int)(Math.random()*10000+1000);
        inputComputer(thing);
        thing.setFormFactor("form" + id);
        thing.setTypeWorkspace("workspace" + id);
        return thing;
    }
}
