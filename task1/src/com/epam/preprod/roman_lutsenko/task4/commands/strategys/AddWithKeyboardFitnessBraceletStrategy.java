package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardFitnessBraceletStrategy implements InputStrategy<FitnessBracelet> {

    @Override
    public FitnessBracelet input(FitnessBracelet thing) {

//        System.out.println("Enter Id > ");
//        thing.setId(InputUtil.intValidationInput());
//
//        System.out.println("Enter nameModel ");
//        thing.setNameModel(InputUtil.stringValidationInput());
//
//        System.out.println("Enter price ");
//        thing.setPrice(InputUtil.longValidationInput());
//
//        System.out.println("Enter autonomy ");
//        thing.setAutonomy(InputUtil.stringValidationInput());

        System.out.println("Enter RAM ");
        thing.setDisplay(InputUtil.stringValidationInput());

        System.out.println("Enter form factor ");
        thing.setStrapMaterial(InputUtil.stringValidationInput());
        return thing;
    }
}
