package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type Laptop.
 *
 * @param <T>
 */
public class AddWithRandomLaptopStrategy<T extends Laptop> extends AddWithRandomComputerStrategy<T> {

    @Override
    public T input(T thing) {
        super.input(thing);
        thing.setDisplayResolution(InputRandomUtil.getRandomDouble(8, 12));
        thing.setWeight(InputRandomUtil.getRandomDouble(2, 0.5));
        return thing;
    }
}
