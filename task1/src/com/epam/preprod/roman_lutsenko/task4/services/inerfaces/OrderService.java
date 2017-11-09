package com.epam.preprod.roman_lutsenko.task4.services.inerfaces;

import com.epam.preprod.roman_lutsenko.task4.entities.Order;

import java.time.LocalDateTime;
import java.util.Map;

public interface OrderService {

    /**
     * Returns copy of orderMap
     * @return copy of orderMap
     */
    Map<LocalDateTime, Order> getOrderMap();

    /**
     * Adding new order to the orderMap.
     * @param localDateTime key
     * @param order value
     */
    void add(LocalDateTime localDateTime, Order order);

    /**
     * Returns order by key localDateTime.
     * @param localDateTime key for search
     * @return order item.
     */
    Order getOrder(LocalDateTime localDateTime);

    /**
     * Removes order frop map by key localDateTime.
     * @param localDateTime ket for removing
     * @return order that removed
     */
    Order remove(LocalDateTime localDateTime);

    /**
     * Removes order from map by key and value.
     * @param localDateTime key
     * @param order value
     * @return <b>true</b> if delete element.
     */
    boolean remove(LocalDateTime localDateTime, Order order);

    /**
     * Clear orderMap.
     */
    void clear();
}
