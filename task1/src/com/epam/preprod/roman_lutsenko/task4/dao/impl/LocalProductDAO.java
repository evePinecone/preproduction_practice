package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.interfaces.ProductDAO;

import java.util.HashMap;
import java.util.Map;

public class LocalProductDAO implements ProductDAO {

    //заменить на хеш сет
    private Map<Integer, Thing> productList;

    @Deprecated
    public LocalProductDAO() {
        productList = new HashMap<>();
    }

    public LocalProductDAO(Map<Integer, Thing> productList) {
        this.productList = productList;
    }

    @Override
    public Map<Integer, Thing> getAllItems() {
        return new HashMap<>(productList);
    }

    @Override
    public void put(Thing thing) {
        productList.put(thing.getId(), thing);
    }

    @Override
    public Thing get(int thingId) {
        return productList.get(thingId);
    }

    @Override
    public Thing remove(int thingId) {
        return productList.remove(thingId);
    }

    @Override
    public Thing remove(Thing object) {
        return productList.remove(object.getId());
    }

    @Override
    public boolean isEmpty() {
        return productList.isEmpty();
    }

}
