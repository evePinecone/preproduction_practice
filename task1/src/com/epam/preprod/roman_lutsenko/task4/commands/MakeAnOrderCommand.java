package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakeAnOrderCommand implements Command {
    @Override
    public void execute(Context context) {
        long totalPrice = byAllItemsInCartLocalCartService(context);

        if (totalPrice == -1) {
            System.out.println("Cart is empty! Please put an items into the cart to make an order.");
        } else {
            //new ShowCartCommand().execute(context);
            showCart(context);
            System.out.println("Total order price: " + totalPrice);
            context.getLocalCartService().clear();
        }
    }

    private long byAllItemsInCartLocalCartService(Context context) {
        List<Thing> listItemsOrder;
        Thing thing;
        Map<Integer, Integer> map = context.getLocalCartService().getAllCart();
        long totalPrice = -1;
        if (!map.isEmpty()) {
            totalPrice = 0;
            for (Map.Entry entry : map.entrySet()) {
                listItemsOrder = new ArrayList<>();
                thing = context.getLocalProductService().get((int) entry.getKey());

                int counter = (int) entry.getValue();
                for (int index = 0; index < counter; index++) {
                    listItemsOrder.add(thing);
                }
                context.getLocalOrderService().add(Util.readDateTime(), new Order(listItemsOrder));
                totalPrice += context.getLocalProductService().get((int) entry.getKey()).getPrice() * (int) entry.getValue();
            }
        }
        return totalPrice;
    }

    private void showCart(Context context) {
        Map<Integer, Integer> map = context.getLocalCartService().getAllCart();
        if (map.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(context.getLocalProductService().get((int) entry.getKey()) + " | pcs:"
                        + entry.getValue());
            }
        }
    }
}
