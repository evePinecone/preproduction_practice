package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type FitnessBracelet.
 *
 * @param <T>
 */
public class AddWithRandomFitnessBraceletStrategy<T extends FitnessBracelet>
        extends AddWithRandomPortableGadgetStrategy<T> {

    @Override
    public T input(T thing) {
        final String DISPLAY_FIELD = "display" + InputRandomUtil.getRandomInt();
        final String STRAP_MATERIAL = "strapMaterial" + InputRandomUtil.getRandomInt();
        super.input(thing);
        thing.setDisplay(DISPLAY_FIELD);
        thing.setStrapMaterial(STRAP_MATERIAL);
        return thing;
    }
}
