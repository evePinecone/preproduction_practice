package com.epam.preprod.roman_lutsenko.task7.builder;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public interface Builder<T extends Thing> {
    void build(T t);
}
