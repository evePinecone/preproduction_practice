package com.epam.preprod.roman_lutsenko.task4.entities;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime dateOrder;
    private List<Thing> orderList;

    public Order(LocalDateTime localDateTime, List<Thing> orderList) {
        this.dateOrder = localDateTime;
        this.orderList = new ArrayList<>(orderList);
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public List<Thing> getOrderList() {
        return new ArrayList<>(orderList);
    }

    @Override
    public String toString() {
        return "Order{" + orderList + '}';
    }
}
