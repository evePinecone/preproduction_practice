package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import java.util.HashMap;
import java.util.Map;

public class LocalCartDAO implements com.epam.preprod.roman_lutsenko.task4.dao.CartDAO {

    private Map<Integer, Integer> cartMap;

    public LocalCartDAO() {
        cartMap = new HashMap<>();
    }

    /**
     * @return return copy HashMap with all items inside.
     */
    @Override
    public Map<Integer, Integer> getAllCart() {
        return new HashMap<Integer, Integer>(cartMap);
    }

    /**
     * Adding thing into cart.
     *
     * @param thingId item to add.
     */
    @Override
    public void add(int thingId) {
        if (cartMap.containsKey(thingId)) {
            cartMap.put(thingId, cartMap.get(thingId) + 1);
        } else {
            cartMap.put(thingId, 1);
        }
    }

    /**
     * @param thingId id of Thing
     * @return Counter of product with thingId in cart
     * or -1 if there is no such product in cart.
     */
    @Override
    public int getCounterProduct(int thingId) {
        if (cartMap.containsKey(thingId)) {
            return cartMap.get(thingId);
        } else {
            return -1;
        }
    }

    /**
     * Clear our HashMap.
     */
    @Override
    public void clear() {
        cartMap.clear();
    }

    /**
     * Remove one element from cart by id.
     *
     * @param thingId id of Thing
     * @return true if element removed, false if no such element.
     */
    @Override
    public boolean remove(int thingId) {
        if (cartMap.containsKey(thingId)) {
            cartMap.put(thingId, cartMap.get(thingId) - 1);
            return true;
        }
        return false;
    }

    /**
     * Remove all element with thingId from cart.
     * @param thingId id of Thing
     * @return true if element removed, false if no such element.
     */
    @Override
    public boolean removeAll(int thingId) {
        if (cartMap.containsKey(thingId)) {
            cartMap.remove(thingId);
            return true;
        }
        return false;
    }

}
