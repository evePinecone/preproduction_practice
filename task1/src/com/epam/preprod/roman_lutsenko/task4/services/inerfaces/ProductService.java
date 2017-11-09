package com.epam.preprod.roman_lutsenko.task4.services.inerfaces;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.List;

public interface ProductService {
    /**
     * Return copy of productList.
     *
     * @return copy of product List.
     */
    List getAllItems();

    /**
     * Replaces product list with thingList.
     *
     * @param thingList change for our base list.
     */
    void setAllItems(List<Thing> thingList);

    /**
     * Adding some Thing to List.
     *
     * @param thing element to add.
     */
    void add(Thing thing);

    /**
     * Return thing by its id, or
     * return <b>null</b> couldn't find element with such id.
     *
     * @param thingId id element to find
     * @return Thing by id;
     */
    Thing get(int index);

    /**
     * Set element thing on index position.
     *
     * @param index index setting into list.
     * @param thing Thing that set on index position.
     */
    void set(int index, Thing thing);

    /**
     * Removes element from index position.
     *
     * @param index of removing element.
     * @return removement element.
     */
    Thing remove(int index);

    /**
     * Removes first occurens object in list.
     *
     * @param object element to remove.
     * @return <b>true</b> if removement took place.
     */
    boolean remove(Object object);

    /**
     * Clear list.
     */
    void clear();

    /**
     * Format output list to console.
     */
    void show();
}
