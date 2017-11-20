package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.ProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;

import java.util.Map;

public class LocalProductService implements ProductService {

    private ProductDAO productDAO;

    public LocalProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Map<Integer, Thing> getAllItems() {
        return productDAO.getAllItems();
    }


    @Override
    public void put(Thing thing) {
        productDAO.put(thing);
    }

    @Override
    public Thing get(int thingId) {
        return productDAO.get(thingId);
    }


    @Override
    public Thing remove(int thingId) {
        return productDAO.remove(thingId);
    }

    @Override
    public Thing remove(Thing object) {
        return productDAO.remove(object);
    }


    @Override
    public void show() {
        Map<Integer, Thing> productList = getAllItems();
        if (productList.isEmpty()) {
            System.out.println("Empty list");
        }
        for (Map.Entry<Integer, Thing> thingEntry : productList.entrySet()) {
            System.out.println(thingEntry.getValue());
        }
    }



}
