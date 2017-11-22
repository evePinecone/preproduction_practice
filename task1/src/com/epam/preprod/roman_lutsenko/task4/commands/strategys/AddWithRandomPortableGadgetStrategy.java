package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;

public abstract class AddWithRandomPortableGadgetStrategy extends AddWithRandomThingStrategy{
    public PortableGadget inputPortableGadget(PortableGadget thing) {
        inputThing(thing);
        thing.setAutonomy("autonomy" + (int)(Math.random()*10000+1000));
        return thing;
    }
}
