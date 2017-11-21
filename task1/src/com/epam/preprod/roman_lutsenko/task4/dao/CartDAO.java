package com.epam.preprod.roman_lutsenko.task4.dao;

import java.util.Map;

public interface CartDAO {

    Map<Integer, Integer> getCacheOfLastFiveAddings();


    /**
     * @return return copy HashMap with all items inside.
     */
    Map<Integer, Integer> getAllCart();

    /**
     * Adding thing into cart.
     *
     * @param thingId item to put.
     */
    void add(int thingId);

    /**
     * @param thingId id of Thing
     * @return Counter of product with thingId in cart
     * or -1 if there is no such product in cart.
     */
    int getCounterProduct(int thingId);

    /**
     * Clear our HashMap.
     */
    void clear();

    /**
     * Remove one element from cart by id.
     *
     * @param thingId id of Thing
     * @return true if element removed, false if no such element.
     */
    boolean remove(int thingId);

    /**
     * Remove all element with thingId from cart.
     *
     * @param thingId id of Thing
     * @return true if element removed, false if no such element.
     */
    boolean removeAll(int thingId);
}
