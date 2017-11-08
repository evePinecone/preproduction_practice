package com.epam.preprod.roman_lutsenko.task4.services;

import java.util.Map;

public interface CartService {
    Map<Integer, Integer> getAllLocalCartService();

    void addLocalCartService(int thingId);

    int getCounterProductLocalCartService(int thingId);

    void clearLocalCartService();

    boolean removeLocalCartService(int thingId);

    boolean removeAllLocalCartService(int thingId);
}
