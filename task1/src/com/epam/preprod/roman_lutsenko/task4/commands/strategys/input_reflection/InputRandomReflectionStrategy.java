package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input_reflection;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.ResourceBundle;

public class InputRandomReflectionStrategy<T extends Thing> extends ImplInputReflectionStrategy<T> {

    public InputRandomReflectionStrategy(Class utilClass) {
        super.utilClass = utilClass;
    }

    @Override
    protected void showInputText(ResourceBundle resourceBundle, String nameField) {

    }
}
