package com.epam.preprod.roman_lutsenko.task4.services;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.InnerThingsDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.ThingsDAO;

import java.util.List;

public class ProductService {

    private ThingsDAO thingsDAO;

    public ThingsDAO getAllItems(){
        this.thingsDAO = new InnerThingsDAO();
        return thingsDAO;
    }

    public void setAllItems(List<Thing> thingList) {
        thingsDAO.setAllItems(thingList);
    }

    public void addProduct(Thing thing) {
        thingsDAO.add(thing);
    }


}
