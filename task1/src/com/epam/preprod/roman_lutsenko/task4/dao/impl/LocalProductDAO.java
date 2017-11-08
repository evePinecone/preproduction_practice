package com.epam.preprod.roman_lutsenko.task4.dao.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LocalProductDAO implements ProductDAO {

    private List<Thing> productList;

    public LocalProductDAO() {
        productList = new ArrayList<>();
        fill();
    }

    @Override
    public List<Thing> getAllItems() {
        return productList;
    }

    @Override
    public void setAllItems(List<Thing> thingList) {
        this.productList = thingList;
    }

    @Override
    public void add(Thing thing) {
        productList.add(thing);
    }

    @Override
    public Thing get(int thingId) {
        for (Thing thing : productList) {
            if(thing.getId() == thingId) {
                return thing;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void set(int index, Thing thing) {
        productList.set(index, thing);
    }

    @Override
    public Thing remove(int index) {
        return productList.remove(index);
    }

    @Override
    public boolean remove(Object object) {
        return productList.remove(object);
    }

    @Override
    public void clear() {
        productList.clear();
    }

    @Override
    public void show() {
        for (Thing thing : productList) {
            System.out.println(thing);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Thing thing : productList) {
            stringBuilder.append(thing).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }


    private LocalProductDAO fill() {
        Laptop laptop;
        for (int index = 1; index < 6; index++) {
            laptop = new Laptop();
            laptop.setId(index);
            productList.add(laptop);
        }
        return this;
    }
}
