package com.epam.preprod.roman_lutsenko.task4.services;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.List;

public interface ProductService {
    List getAllItemsFromLocalProduct();

    void setAllItemsToLocalProduct(List<Thing> thingList);

    void addLocalProduct(Thing thing);

    Thing getLocalProduct(int index);

    void setLocalProduct(int index, Thing thing);

    Thing removeLocalProduct(int index);

    boolean removeLocalProduct(Object object);

    void clearLocalProduct();

    void showLocalProduct();
}
