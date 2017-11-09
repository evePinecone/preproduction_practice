package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Map;

public class MakeAnOrderCommand implements Command {
    @Override
    public void execute(Context context) {
        long totalPrice = byAllItemsInCartLocalCartService(context);

        if (totalPrice == -1) {
            System.out.println("Cart is empty! Please add an items into the cart to make an order.");
        } else {
            new ShowCartCommand().execute(context);
            System.out.println("Total order price: " + totalPrice);
            context.getLocalCartService().clear();
        }
    }

    public long byAllItemsInCartLocalCartService(Context context) {
        Map<Integer, Integer> map = context.getLocalCartService().getAllCart();
        long totalPrice = -1;
        if (!map.isEmpty()) {
            totalPrice = 0;
            for (Map.Entry entry : map.entrySet()) {
                totalPrice += context.getLocalProductService().get((int) entry.getKey()).getPrice() * (int) entry.getValue();
            }
        }
        return totalPrice;
    }
}
