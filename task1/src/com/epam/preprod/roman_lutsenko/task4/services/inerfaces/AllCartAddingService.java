package com.epam.preprod.roman_lutsenko.task4.services.inerfaces;

import java.util.Map;

public interface AllCartAddingService {
    /**
     * Add id of Cart adding element to AllCartAdding
     *
     * @param thingId
     */
    void add(int thingId);

    /**
     * Return copy of Map that contains all Cart addings.
     *
     * @return copy of Map that contains all Cart addings.
     */
    Map<Integer, Integer> getAllCartAdding();

    /**
     * Clear AllCartAdding map.
     */
    void clear();

    /**
     * Return id of element on position index in Map.
     *
     * @param index index of element.
     * @return id of element on index position in AllCartMap.
     */
    int getThingIdByIndexInCartItemsMap(int index);

    /**
     * Size of Map with all input items in cart.
     *
     * @return
     */
    int size();

    /**
     * Check map.
     *
     * @return true if map contains element.
     */
    boolean isEmpty();
}
