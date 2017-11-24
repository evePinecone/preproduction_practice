package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

public abstract class AddWithRandomPortableGadgetStrategy<T extends PortableGadget> extends AddWithRandomThingStrategy<T>{

    private final String AUTONOMY_FIELD = "autonomy" + InputRandomUtil.getRandomInt();

    @Override
    public T input(T thing) {
        super.input(thing);
        thing.setAutonomy(AUTONOMY_FIELD);
        return thing;
    }
}
