package com.epam.preprod.roman_lutsenko.task4.dao;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.List;

public interface ProductDAO {
    List<Thing> getAllItems();

    void setAllItems(List<Thing> thingList);

    void add(Thing thing);

    /**
     * @param thingId
     * @return Thing by id;
     */
    Thing get(int thingId);

    void set(int index, Thing thing);

    Thing remove(int index);

    boolean remove(Object object);

    void clear();

    void show();
}
