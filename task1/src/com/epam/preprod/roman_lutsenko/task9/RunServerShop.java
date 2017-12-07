package com.epam.preprod.roman_lutsenko.task9;

public class RunServerShop {
    public static void main(String[] args) {
        Shop shop = new Shop(); // нет
        shop.run(); // мэйн и так у нас в отдельном потоке, магазин будет сам в отдельном потоке, ну да, нам так и надо
    }
}
