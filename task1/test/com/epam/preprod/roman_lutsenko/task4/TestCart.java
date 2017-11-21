package com.epam.preprod.roman_lutsenko.task4;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.controller.MenuController;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalOrderDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalCartService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalOrderService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;

import java.util.HashMap;
import java.util.Map;

public class TestCart {

    public static void main(String[] args) {

        LocalProductDAO localProductDAO = new LocalProductDAO(fill());
        LocalCartDAO localCartDAO = new LocalCartDAO();
        LocalOrderDAO localOrderDAO = new LocalOrderDAO();

        LocalProductService localProductService = new LocalProductService(localProductDAO);
        LocalCartService localCartService = new LocalCartService(localCartDAO);
        LocalOrderService localOrderService = new LocalOrderService(localOrderDAO);

        Context context = new Context(localProductService, localCartService, localOrderService);
        new MenuController().menu(context);
    }

    private static Map<Integer, Thing> fill() {
        Laptop laptop;
        Map<Integer, Thing> productList = new HashMap<>();
        for (int index = 1; index < 6; index++) {
            laptop = new Laptop();
            laptop.setId(index);
            laptop.setPrice(index * 100);
            laptop.setNameModel("laptop" + index);
            productList.put(laptop.getId(), laptop);
        }
        return productList;
    }
}
