package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import com.epam.preprod.roman_lutsenko.task4.constants.DAOConstants;
import com.epam.preprod.roman_lutsenko.task4.dao.CartDAO;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LocalCartDAO implements CartDAO {

    private Map<Integer, Integer> cartMap;
    private Map<Integer, Integer> addingItemsIntoCart;

    public LocalCartDAO() {
        cartMap = new HashMap<>();
        addingItemsIntoCart = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return addingItemsIntoCart.size() > DAOConstants.MAX_CASH_IN_CART;
            }
        };
    }

    @Override
    public Map<Integer, Integer> getCacheOfLastFiveAddings() {
        return new LinkedHashMap<>(addingItemsIntoCart);
    }

    @Override
    public void addToCash(int thingId) {
        addingItemsIntoCart.put(addingItemsIntoCart.size() + 1, thingId);
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

    @Override
    public void clear() {
        cartMap.clear();
    }

    @Override
    public boolean remove(int thingId) {
        if (cartMap.containsKey(thingId)) {
            if (cartMap.get(thingId) > 1) {
                cartMap.put(thingId, cartMap.get(thingId) - 1);
            } else {
                cartMap.remove(thingId);
            }
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
