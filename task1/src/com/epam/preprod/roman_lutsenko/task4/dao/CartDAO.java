package com.epam.preprod.roman_lutsenko.task4.dao;

import java.util.Map;

public interface CartDAO {
    Map<Integer, Integer> getAllCart();

    void add(int thingId);

    int getCounterProduct(int thingId);

    void clear();

    boolean remove(int thingId);

    boolean removeAll(int thingId);
}
