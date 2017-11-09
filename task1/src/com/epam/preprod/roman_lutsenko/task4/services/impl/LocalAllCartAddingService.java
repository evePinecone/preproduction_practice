package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task4.dao.interfaces.AllCartAddingDAO;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.AllCartAddingService;

import java.util.Map;

public class LocalAllCartAddingService implements AllCartAddingService {

    private AllCartAddingDAO allCartAddingDAO;

    public LocalAllCartAddingService(AllCartAddingDAO allCartAddingDAO) {
        this.allCartAddingDAO = allCartAddingDAO;
    }

    @Override
    public void add(int thingId) {
        allCartAddingDAO.add(thingId);
    }

    @Override
    public Map<Integer, Integer> getAllCartAdding() {
        return allCartAddingDAO.getMap();
    }

    @Override
    public void clear() {
        allCartAddingDAO.clear();
    }

    @Override
    public int getThingIdByIndexInCartItemsMap(int index) {
        return allCartAddingDAO.getThingIdByIndexInCartItemsMap(index);
    }

    @Override
    public int size() {
        return allCartAddingDAO.size();
    }

    @Override
    public boolean isEmpty() {
        return allCartAddingDAO.isEmpty();
    }

}
