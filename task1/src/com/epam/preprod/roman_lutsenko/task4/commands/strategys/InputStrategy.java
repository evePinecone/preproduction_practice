package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

/**
 * Interface to mark strategies as input. Contains method input(T) : T, to set element with specified type T/
 *
 * @param <T> Mark to specified type of creation strategy.
 */
public interface InputStrategy<T extends Thing> {
    /**
     * Returns <b>thing</b> with setted fields with specified strategies.
     *
     * @param thing element which fields to set.
     * @return thing with setted fields.
     */
    T input(T thing);
}
