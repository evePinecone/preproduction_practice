package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class AddWithKeyboardFitnessBraceletStrategy extends AddWithKeyboardPortableGadgetStrategy implements InputStrategy<FitnessBracelet> {

    @Override
    public FitnessBracelet input(FitnessBracelet thing) {
        inputPortableGadget(thing);
        System.out.println("Enter display type ");
        thing.setDisplay(InputUtil.stringValidationInput());

        System.out.println("Enter strapMaterial ");
        thing.setStrapMaterial(InputUtil.stringValidationInput());
        return thing;
    }
}
