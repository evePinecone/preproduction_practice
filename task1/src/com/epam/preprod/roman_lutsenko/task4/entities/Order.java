package com.epam.preprod.roman_lutsenko.task4.entities;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Thing> orderList;

    public Order() {
        orderList = new ArrayList<>();
    }

    public Order(List<Thing> orderList) {
        this.orderList = orderList;
    }

    public List<Thing> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Thing> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Order{" + orderList + '}';
    }
}
