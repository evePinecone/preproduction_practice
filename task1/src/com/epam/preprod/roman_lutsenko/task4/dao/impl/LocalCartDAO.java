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
        return new HashMap<>(cartMap);
    }

    @Override
    public void add(int thingId) {
        Integer amount = cartMap.putIfAbsent(thingId, 1);
        if (amount != null) {
            cartMap.put(thingId, amount + 1);
        }
    }

    @Override
    public int getCounterProduct(int thingId) {
        return cartMap.getOrDefault(thingId, -1);
    }

    @Deprecated
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
