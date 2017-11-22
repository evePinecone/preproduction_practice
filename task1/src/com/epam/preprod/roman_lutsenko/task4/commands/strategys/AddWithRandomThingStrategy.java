package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public abstract class AddWithRandomThingStrategy implements InputStrategy<Thing>{
    @Override
    public Thing input(Thing thing) {
        thing.setId((int)(Math.random() * 10000 + 1000));
        thing.setNameModel("Laptop" + (int)(Math.random() * 10000 + 1000));
        thing.setPrice((long)(Math.random() * 10000 + 1000));

        return thing;
    }
}
