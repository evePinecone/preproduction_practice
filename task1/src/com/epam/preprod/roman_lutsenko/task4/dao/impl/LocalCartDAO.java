package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import com.epam.preprod.roman_lutsenko.task4.dao.interfaces.CartDAO;

import java.util.HashMap;
import java.util.Map;

public class LocalCartDAO implements CartDAO {

    private Map<Integer, Integer> cartMap;

    public LocalCartDAO() {
        cartMap = new HashMap<>();
    }

    @Override
    public Map<Integer, Integer> getAllCart() {
        return new HashMap<Integer, Integer>(cartMap);
    }

    @Override
    public void add(int thingId) {
        if (cartMap.containsKey(thingId)) {
            cartMap.put(thingId, cartMap.get(thingId) + 1);
        } else {
            cartMap.put(thingId, 1);
        }
    }

    @Override
    public int getCounterProduct(int thingId) {
        if (cartMap.containsKey(thingId)) {
            return cartMap.get(thingId);
        } else {
            return -1;
        }
    }

    @Override
    public void clear() {
        cartMap.clear();
    }

    @Override
    public boolean remove(int thingId) {
        if (cartMap.containsKey(thingId)) {
            cartMap.put(thingId, cartMap.get(thingId) - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(int thingId) {
        if (cartMap.containsKey(thingId)) {
            cartMap.remove(thingId);
            return true;
        }
        return false;
    }

}
