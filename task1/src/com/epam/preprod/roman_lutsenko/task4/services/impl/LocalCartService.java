package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task4.dao.CartDAO;
import com.epam.preprod.roman_lutsenko.task4.services.CartService;

import java.util.Map;

public class LocalCartService implements CartService {

    private CartDAO cartDAO;

    public LocalCartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    public Map<Integer, Integer> getAllCart() {
        return cartDAO.getAllCart();
    }

    @Override
    public void add(int thingId) {
        cartDAO.add(thingId);
        cartDAO.addToCash(thingId);
    }

    @Override
    public int getCounterProduct(int thingId) {
        return cartDAO.getCounterProduct(thingId);
    }

    @Override
    public void clear() {
        cartDAO.clear();
    }

    @Override
    public boolean remove(int thingId) {
        return cartDAO.remove(thingId);
    }

    @Override
    public boolean removeAll(int thingId) {
        return cartDAO.removeAll(thingId);
    }

    @Override
    public Map<Integer, Integer> getCacheOfLastFiveAddings(){
        return cartDAO.getCacheOfLastFiveAddings();
    }

}