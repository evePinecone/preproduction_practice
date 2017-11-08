package com.epam.preprod.roman_lutsenko.task4.services.impl;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;

import java.util.List;

public class LocalProductService implements ProductService {

    private LocalProductDAO localProductDAO;

    public LocalProductService(LocalProductDAO localProductDAO) {
        this.localProductDAO = localProductDAO;
    }

    @Override
    public List getAllItemsFromLocalProduct(){
        return localProductDAO.getAllItems();
    }

    @Override
    public void setAllItemsToLocalProduct(List<Thing> thingList) {
        localProductDAO.setAllItems(thingList);
    }

    @Override
    public void addLocalProduct(Thing thing) {
        localProductDAO.add(thing);
    }

    @Override
    public Thing getLocalProduct(int index) {
        return localProductDAO.get(index);
    }

    @Override
    public void setLocalProduct(int index, Thing thing) {
        localProductDAO.set(index, thing);
    }

    @Override
    public Thing removeLocalProduct(int index) {
        return localProductDAO.remove(index);
    }

    @Override
    public boolean removeLocalProduct(Object object) {
        return localProductDAO.remove(object);
    }

    @Override
    public void clearLocalProduct() {
        localProductDAO.clear();
    }

    @Override
    public void showLocalProduct() {
        localProductDAO.show();
    }

    @Override
    public String toString() {
        return localProductDAO.toString();
    }
}
