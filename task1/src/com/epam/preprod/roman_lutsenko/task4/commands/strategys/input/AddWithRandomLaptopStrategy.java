package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;

/**
 * Setting with Random fields of element specified by type Laptop.
 *
 * @param <T>
 */
public class AddWithRandomLaptopStrategy<T extends Laptop>
        extends AddWithRandomComputerStrategy<T> {

    @Override
    public T input(T thing) {
        final double RANGE_DISPLAY_SIZE = 8;
        final double LOW_BORDER_DISPLYAY_SIZE = 12;
        final double RANGE_WEIGHT = 2;
        final double LOW_BORDER_WEIGHT = 0.5;
        super.input(thing);
        thing.setDisplayResolution(InputRandomUtil.getRandomDouble(RANGE_DISPLAY_SIZE, LOW_BORDER_DISPLYAY_SIZE));
        thing.setWeight(InputRandomUtil.getRandomDouble(RANGE_WEIGHT, LOW_BORDER_WEIGHT));
        return thing;
    }
}
