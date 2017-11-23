package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

import java.util.Scanner;

public class AddWithRandomFitnessBraceletStrategy<T extends FitnessBracelet> extends AddWithRandomPortableGadgetStrategy<T> {
    private final String DISPLAY_FIELD = "display" + InputRandomUtil.getRandomInt();
    private final String STRAP_MATERIAL = "strapMaterial" + InputRandomUtil.getRandomInt();

    @Override
    public T input(T thing) {
        super.input(thing);
        thing.setDisplay(DISPLAY_FIELD);
        thing.setStrapMaterial(STRAP_MATERIAL);
        return thing;
    }
}
