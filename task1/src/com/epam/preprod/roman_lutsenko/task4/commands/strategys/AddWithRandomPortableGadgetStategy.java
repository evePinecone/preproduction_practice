package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;

public abstract class AddWithRandomPortableGadgetStategy implements InputStrategy<PortableGadget> {
    @Override
    public PortableGadget input(PortableGadget thing) {
        thing.setAutonomy("autonomy" + (int)(Math.random()*10000+1000));
        return thing;
    }
}
