package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.services.CartService;

import java.util.Map;

public class LocalCartService implements CartService {

    private LocalCartDAO localCartDAO;

    public LocalCartService(LocalCartDAO localCartDAO) {
        this.localCartDAO = localCartDAO;
    }

    @Override
    public Map<Integer, Integer> getAllLocalCartService() {
        return localCartDAO.getAllCart();
    }

    @Override
    public void addLocalCartService(int thingId) {
        localCartDAO.add(thingId);
    }

    @Override
    public int getCounterProductLocalCartService(int thingId) {
        return localCartDAO.getCounterProduct(thingId);
    }

    @Override
    public void clearLocalCartService() {
        localCartDAO.clear();
    }

    @Override
    public boolean removeLocalCartService(int thingId) {
        return localCartDAO.remove(thingId);
    }

    @Override
    public boolean removeAllLocalCartService(int thingId) {
        return localCartDAO.removeAll(thingId);
    }
}