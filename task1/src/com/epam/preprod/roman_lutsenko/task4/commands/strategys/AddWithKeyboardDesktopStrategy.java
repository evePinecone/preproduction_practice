package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardDesktopStrategy implements InputStrategy<Desktop> {

    @Override
    public Desktop input(Desktop thing) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Id > ");
        thing.setId(InputUtil.intValidationInput());

        // перекинуть в обвертку считывание строки.
        System.out.println("Enter nameModel ");
        thing.setNameModel(scanner.nextLine());

        System.out.println("Enter price ");
        thing.setPrice(InputUtil.longValidationInput());

        System.out.println("Enter processors name ");
        thing.setNameProcessor(scanner.nextLine());

        System.out.println("Enter RAM ");
        thing.setRAM(InputUtil.intValidationInput());

        System.out.println("Enter form factor ");
        thing.setFormFactor(scanner.nextLine());

        System.out.println("Enter type workspace ");
        thing.setTypeWorkspace(scanner.nextLine());
        return thing;
    }
}

