package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

public abstract class AddWithRandomThingStrategy<T extends Thing> implements InputStrategy<T> {

    private final String NAME_MODEL_FIELD = "Thing" + InputRandomUtil.getRandomInt();

    @Override
    public T input(T thing) {
        thing.setId(InputRandomUtil.getRandomInt());
        thing.setNameModel(NAME_MODEL_FIELD);
        thing.setPrice(InputRandomUtil.getRandomLong());
        return thing;
    }
}
