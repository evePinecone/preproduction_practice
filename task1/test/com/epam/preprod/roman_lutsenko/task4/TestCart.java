package com.epam.preprod.roman_lutsenko.task4;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.controller.MenuController;

public class TestCart {

    public static void main(String[] args) {
        Context context = new Context();
        new MenuController().menu(context);
    }

//    void initProduct(LocalProductService productService) {
//        productService.addProduct(new Laptop());
//    }
}
