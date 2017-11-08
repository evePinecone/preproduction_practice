package com.epam.preprod.roman_lutsenko.task4.dao;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.ArrayList;
import java.util.List;

public class InnerThingsDAO implements ThingsDAO {

    List<Thing> thingList;

    public InnerThingsDAO() {
        thingList = new ArrayList<>();
    }

    @Override
    public List<Thing> getAllItems() {
        return thingList;
    }

    @Override
    public void setAllItems(List<Thing> thingList) {
        this.thingList = thingList;
    }

  /*  public InnerThingsDAO fill() {
        Laptop laptop;
        List<Thing> list = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            laptop = new Laptop();
            laptop.setId(index);
            list.add(laptop);
        }
        return this;
    }*/
}
