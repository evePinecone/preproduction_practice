package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import com.epam.preprod.roman_lutsenko.task4.entities.Order;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class LocalOrderDAO implements com.epam.preprod.roman_lutsenko.task4.dao.interfaces.OrderDAO {

    private Map<LocalDateTime, Order> orderMap;

    public LocalOrderDAO() {
        orderMap = new TreeMap<>();
    }

    @Override
    public Map<LocalDateTime, Order> getOrderMap() {
        return new TreeMap<LocalDateTime, Order>(orderMap);
    }

    @Override
    public void add(LocalDateTime localDateTime, Order order) {
        orderMap.put(localDateTime, order);
    }

    @Override
    public Order getOrder(LocalDateTime localDateTime) {
        return orderMap.get(localDateTime);
    }

    @Override
    public Order remove(LocalDateTime localDateTime) {
        return orderMap.remove(localDateTime);
    }

    @Override
    public boolean remove(LocalDateTime localDateTime, Order order) {
        return orderMap.remove(localDateTime, order);
    }

    @Override
    public void clear() {
        orderMap.clear();
    }

}
