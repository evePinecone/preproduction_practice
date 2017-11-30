package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type Thing.
 *
 * @param <T>
 */
public abstract class AddWithRandomThingStrategy<T extends Thing>
        implements InputStrategy<T> {

    @Override
    public T input(T thing) {
        final String NAME_MODEL_FIELD = "Thing" + InputRandomUtil.getRandomInt();
        thing.setId(InputRandomUtil.getRandomInt());
        thing.setNameModel(NAME_MODEL_FIELD);
        thing.setPrice(InputRandomUtil.getRandomLong());
        return thing;
    }
}
