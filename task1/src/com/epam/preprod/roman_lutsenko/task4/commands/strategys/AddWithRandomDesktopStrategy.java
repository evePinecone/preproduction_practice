package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

import java.util.Scanner;

public class AddWithRandomDesktopStrategy<T extends Desktop> extends AddWithRandomComputerStrategy<T>{
    private final String FORM_FACTOR_FIELD = "form" + InputRandomUtil.getRandomInt();
    private final String TYPE_WORKSPACE_FIELD = "workspace" + InputRandomUtil.getRandomInt();

    @Override
    public T input(T thing) {
        super.input(thing);
        thing.setFormFactor(FORM_FACTOR_FIELD);
        thing.setTypeWorkspace(TYPE_WORKSPACE_FIELD);
        return thing;
    }
}
