package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Map;

public class ShowCartCommand implements Command {
    @Override
    public void execute(Context context) {
      //  context.showLocalCartService();
        Map<Integer, Integer> map = context.getAllLocalCartService();
        if (map.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(context.getLocalProductService((int) entry.getKey()) + " | pcs:"
                        + entry.getValue());
            }
        }
    }
}
