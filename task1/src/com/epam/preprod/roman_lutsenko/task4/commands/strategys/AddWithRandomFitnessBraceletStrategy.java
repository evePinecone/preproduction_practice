package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;

import java.util.Scanner;

public class AddWithRandomFitnessBraceletStrategy extends AddWithRandomPortableGadgetStrategy implements InputStrategy<FitnessBracelet> {

    @Override
    public FitnessBracelet input(FitnessBracelet thing) {
        int id = (int)(Math.random()*10000+1000);
        inputPortableGadget(thing);
        thing.setDisplay("display" + id);
        thing.setStrapMaterial("strapMaterial" + id);
        return thing;
    }
}
