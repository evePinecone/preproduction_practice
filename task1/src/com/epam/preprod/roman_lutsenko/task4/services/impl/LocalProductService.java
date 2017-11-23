package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.constants.Paths;
import com.epam.preprod.roman_lutsenko.task4.dao.ProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.FileSavable;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;
import com.epam.preprod.roman_lutsenko.task4.util.IncorrectIdException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LocalProductService implements ProductService, FileSavable {

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
            throw new IncorrectIdException("In LocalProductService.class");
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
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(Paths.SERIALIZE_PRODUCT_FILE_NAME_PATH))){
            oos.writeObject(getAllItems());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unSerializeProduct() {
        Map<Integer, Thing> map = new HashMap<>();
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(Paths.SERIALIZE_PRODUCT_FILE_NAME_PATH));
            map = (Map<Integer, Thing>) oos.readObject();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No file to deserialize.");
        }

        for (Thing value : map.values()) {
            put(value);
        }
    }

}
