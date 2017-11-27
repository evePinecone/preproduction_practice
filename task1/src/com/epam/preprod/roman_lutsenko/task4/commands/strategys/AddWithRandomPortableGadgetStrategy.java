package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type PortableGadget.
 *
 * @param <T>
 */
public abstract class AddWithRandomPortableGadgetStrategy<T extends PortableGadget>
        extends AddWithRandomThingStrategy<T> {

    @Override
    public T input(T thing) {
        final String AUTONOMY_FIELD = "autonomy" + InputRandomUtil.getRandomInt();
        super.input(thing);
        thing.setAutonomy(AUTONOMY_FIELD);
        return thing;
    }
}
