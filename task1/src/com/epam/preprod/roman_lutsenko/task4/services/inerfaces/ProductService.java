package com.epam.preprod.roman_lutsenko.task4.services.inerfaces;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    /**
     * Return copy of productList.
     *
     * @return copy of product List.
     */
    Map<Integer, Thing> getAllItems();


    /**
     * Adding Thing to List.
     *
     * @param thing element to put.
     */
    void put(Thing thing);

    /**
     * Return thing by its id, or
     * return <b>null</b> couldn't find element with such id.
     *
     * @param thingId id element to find
     * @return Thing by id;
     */
    Thing get(int thingId);


    /**
     * Removes element with thingId.
     *
     * @param thingId of removing element.
     * @return removement element.
     */
    Thing remove(int thingId);

    /**
     * Removes occurrence object in map.
     *
     * @param object element to remove.
     * @return <b>true</b> if removement took place.
     */
    Thing remove(Thing object);

    /**
     * Format output list to console.
     */
    void show();

}
