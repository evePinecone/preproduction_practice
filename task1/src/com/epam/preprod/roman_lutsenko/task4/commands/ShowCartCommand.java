package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Map;

/**
 * Show all items from cart.
 */
public class ShowCartCommand implements Command {
    @Override
    public void execute(Context context) {
        Map<Integer, Integer> map = context.getLocalCartService().getAllCart();
        if (map.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(context.getLocalProductService().get(entry.getKey()) + CommandConstants.SEPARATOR_FOR_THING_PIECES
                        + entry.getValue());
            }
        }
    }
}
