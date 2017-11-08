package com.epam.preprod.roman_lutsenko.task4;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.controller.MenuController;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;

public class TestCart {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        staticInitProduct(productService);
        new MenuController().menu();
    }

    void initProduct(ProductService productService) {
        productService.addProduct(new Laptop());
    }

    static void staticInitProduct(ProductService productService) {
        Laptop laptop;
        for (int index = 0; index < 5; index++) {
            laptop = new Laptop();
            laptop.setId(index);
            productService.addProduct(laptop);
        }
    }
}
