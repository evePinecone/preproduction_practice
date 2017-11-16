package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public interface InputStrategy<T extends Thing> {

    T input(T thing);
}
