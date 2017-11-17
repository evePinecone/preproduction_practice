package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;

import java.util.Scanner;

public class AddWithRandomDesktopStrategy implements InputStrategy<Desktop>{

    @Override
    public Desktop input(Desktop thing) {
        Scanner scanner = new Scanner(System.in);
        int id = (int)(Math.random()*10000+1000);
        thing.setId(id);
        thing.setNameModel("Desktop" + id);
        thing.setPrice((long)(Math.random() * 10000 + 1000));
        thing.setNameProcessor("processor" + id);
        thing.setRAM((int)(Math.random() * 5000 + 1000));
        thing.setFormFactor("form" + id);
        thing.setTypeWorkspace("workspace" + id);
        return thing;
    }
}
