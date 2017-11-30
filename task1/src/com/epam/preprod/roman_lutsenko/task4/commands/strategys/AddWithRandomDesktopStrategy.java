package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type Desktop.
 *
 * @param <T>
 */
public class AddWithRandomDesktopStrategy<T extends Desktop> extends AddWithRandomComputerStrategy<T> {

    @Override
    public T input(T thing) {
        final String FORM_FACTOR_FIELD = "form" + InputRandomUtil.getRandomInt();
        final String TYPE_WORKSPACE_FIELD = "workspace" + InputRandomUtil.getRandomInt();
        super.input(thing);
        thing.setFormFactor(FORM_FACTOR_FIELD);
        thing.setTypeWorkspace(TYPE_WORKSPACE_FIELD);
        return thing;
    }
}
