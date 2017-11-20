package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Creates an order with all items in cart. Request for input date from keyboard.
 */
public class MakeAnOrderCommand implements Command {
    @Override
    public void execute(Context context) {
        long totalPrice = buyAllItemsInCartLocalCartService(context);

        if (totalPrice == -1) {
            System.out.println("Cart is empty! Please put an items into the cart to make an order.");
        } else {
            showCart(context);
            System.out.println("Total order price: " + totalPrice);
            context.getLocalCartService().clear();
        }
    }

    private long buyAllItemsInCartLocalCartService(Context context) {
        List<Thing> listItemsOrder = new ArrayList<>();
        Thing thing;
        Map<Integer, Integer> map = context.getLocalCartService().getAllCart();
        if (map.isEmpty()) {
            return -1;
        }
        long totalPrice = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            thing = context.getLocalProductService().get(entry.getKey());

            int counter = entry.getValue();
            for (int index = 0; index < counter; index++) {
                listItemsOrder.add(thing);
            }
            totalPrice += context.getLocalProductService().get(entry.getKey()).getPrice() * entry.getValue();
        }
        LocalDateTime localDateTime = InputUtil.readDateTime();
        context.getLocalOrderService().add(localDateTime, new Order(localDateTime, listItemsOrder));
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
