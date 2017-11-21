package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardFitnessBraceletStrategy implements InputStrategy<FitnessBracelet> {

    @Override
    public FitnessBracelet input(FitnessBracelet thing) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id > ");
        thing.setId(InputUtil.intValidationInput());
        System.out.println("Enter nameModel ");
        thing.setNameModel(scanner.nextLine());
        System.out.println("Enter price ");
        thing.setPrice(InputUtil.longValidationInput());
        System.out.println("Enter autonomy ");
        thing.setAutonomy(scanner.nextLine());
        System.out.println("Enter RAM ");
        thing.setDisplay(scanner.nextLine());
        System.out.println("Enter form factor ");
        thing.setStrapMaterial(scanner.nextLine());
        return thing;
    }
}
