package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input_reflection;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.ResourceBundle;

public class InputKeyboardReflectionStrategy<T extends Thing> extends ImplInputReflectionStrategy<T> {

    public InputKeyboardReflectionStrategy(Class utilClass) {
        super.utilClass = utilClass;
    }

    @Override
    protected void showInputText(ResourceBundle resourceBundle, String nameField) {
        System.out.println(resourceBundle.getString("enter") + " "
                + resourceBundle.getString(nameField));

    }

}
