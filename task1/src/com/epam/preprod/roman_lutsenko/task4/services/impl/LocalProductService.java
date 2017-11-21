package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.ProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;
import com.epam.preprod.roman_lutsenko.task4.constants.Paths;

import java.io.*;
import java.util.HashMap;
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
        if (productDAO.get(thing.getId()) == null) {
            productDAO.put(thing);
        } else {
            //wraper exception
            throw new IllegalArgumentException();
        }
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

    @Override
    public void serializeProduct() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Paths.SERIALIZE_PRODUCT_FILE_NAME_PATH));
            oos.writeObject(getAllItems());
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unSerializeProduct() {
        Map map = new HashMap<>();
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(Paths.SERIALIZE_PRODUCT_FILE_NAME_PATH));
            map = (Map) oos.readObject();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No file to deserialize.");
        }

        for (Object value : map.values()) {
            put((Thing) value);
        }
    }

}
