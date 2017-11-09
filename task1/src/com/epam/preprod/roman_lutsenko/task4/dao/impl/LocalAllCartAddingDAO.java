package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import com.epam.preprod.roman_lutsenko.task4.dao.interfaces.AllCartAddingDAO;

import java.util.LinkedHashMap;
import java.util.Map;

public class LocalAllCartAddingDAO implements AllCartAddingDAO {

    private Map<Integer, Integer> allCartItemsMap;

    public LocalAllCartAddingDAO() {
        allCartItemsMap = new LinkedHashMap<>();
    }

    @Override
    public void add(int thingId) {
        allCartItemsMap.put(allCartItemsMap.size() + 1, thingId);
    }

    @Override
    public Map<Integer, Integer> getMap() {
        return new LinkedHashMap<>(allCartItemsMap);
    }

    @Override
    public void clear() {
        allCartItemsMap.clear();
    }

    @Override
    public int getThingIdByIndexInCartItemsMap(int index) {
        return allCartItemsMap.get(index);
    }

    @Override
    public int size() {
        return allCartItemsMap.size();
    }

    @Override
    public boolean isEmpty() {
        return allCartItemsMap.isEmpty();
    }

}
