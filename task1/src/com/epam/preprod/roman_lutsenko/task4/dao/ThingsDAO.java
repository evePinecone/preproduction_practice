package com.epam.preprod.roman_lutsenko.task4.dao;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.List;

public interface ThingsDAO {
    List<Thing> getAllItems();

    void setAllItems(List<Thing> thingList);

    void add(Thing thing);

    Thing get(int index);
}
