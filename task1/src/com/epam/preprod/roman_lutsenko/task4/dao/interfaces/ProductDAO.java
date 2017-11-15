package com.epam.preprod.roman_lutsenko.task4.dao.interfaces;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.Map;

public interface ProductDAO {

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
     * Check if map of products is empty.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    boolean isEmpty();
}
