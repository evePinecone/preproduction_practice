package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;

import java.util.Scanner;

public class AddWithRandomFitnessBraceletStrategy implements InputStrategy<FitnessBracelet> {

    @Override
    public FitnessBracelet input(FitnessBracelet thing) {
        int id = (int)(Math.random()*10000+1000);
        thing.setId(id);
        thing.setNameModel("Desktop" + id);
        thing.setPrice((long)(Math.random() * 10000 + 1000));
        thing.setAutonomy("autonomy" + id);
        thing.setDisplay("display" + id);
        thing.setStrapMaterial("strapMaterial" + id);
        return thing;
    }
}
