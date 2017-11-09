package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.interfaces.ProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.ProductService;

import java.util.List;

public class LocalProductService implements ProductService {

    private ProductDAO productDAO;

    public LocalProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List getAllItems() {
        return productDAO.getAllItems();
    }

    @Override
    public void setAllItems(List<Thing> thingList) {
        productDAO.setAllItems(thingList);
    }

    @Override
    public void add(Thing thing) {
        productDAO.add(thing);
    }

    @Override
    public Thing get(int thingId) {
        return productDAO.get(thingId);
    }

    @Override
    public void set(int index, Thing thing) {
        productDAO.set(index, thing);
    }

    @Override
    public Thing remove(int index) {
        return productDAO.remove(index);
    }

    @Override
    public boolean remove(Object object) {
        return productDAO.remove(object);
    }

    @Override
    public void clear() {
        productDAO.clear();
    }

    @Override
    public void show() {
        productDAO.show();
    }

    @Override
    public String toString() {
        return productDAO.toString();
    }
}
