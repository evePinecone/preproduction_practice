package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task4.dao.OrderDAO;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.services.OrderService;

import java.time.LocalDateTime;
import java.util.Map;

public class LocalOrderService implements OrderService {

    private OrderDAO orderDAO;

    public LocalOrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Map<LocalDateTime, Order> getOrderMap() {
        return orderDAO.getOrderMap();
    }

    @Override
    public void add(LocalDateTime localDateTime, Order order) {
        orderDAO.add(localDateTime, order);
    }

    @Override
    public Order getOrder(LocalDateTime localDateTime) {
        return orderDAO.getOrder(localDateTime);
    }

    @Override
    public Order remove(LocalDateTime localDateTime) {
        return orderDAO.remove(localDateTime);
    }

    @Override
    public boolean remove(LocalDateTime localDateTime, Order order) {
        return orderDAO.remove(localDateTime, order);
    }

}
