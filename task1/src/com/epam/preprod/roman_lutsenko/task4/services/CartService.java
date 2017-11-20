package com.epam.preprod.roman_lutsenko.task4.services;

import java.util.Map;

public interface CartService {

    Map<Integer, Integer> getCacheOfLastFiveAddings();

    void addToCash(int thingId);

    /**
     * Returns the copy of Cart map.
     *
     * @return the copy of Cart map
     */
    Map<Integer, Integer> getAllCart();

    /**
     * Add item by it id to current Cart.
     * If this item contains in Cart, increment counter in map.
     *
     * @param thingId id of adding element
     */
    void add(int thingId);

    /**
     * Return number of included element to Cart with id = thingId.
     *
     * @param thingId id of Thing
     * @return Counter of product with thingId in cart
     * or -1 if there is no such product in cart.
     */
    int getCounterProduct(int thingId);

    /**
     * Clear cart map.
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
