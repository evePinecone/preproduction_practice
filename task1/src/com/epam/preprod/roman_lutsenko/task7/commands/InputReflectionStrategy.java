package com.epam.preprod.roman_lutsenko.task7.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

public interface InputReflectionStrategy<T extends Thing> {
    void build(T t, Context context);
}
