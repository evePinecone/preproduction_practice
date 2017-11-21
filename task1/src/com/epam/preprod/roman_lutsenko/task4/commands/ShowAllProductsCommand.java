package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Map;

/**
 * Show all items from catalog.
 */
public class ShowAllProductsCommand implements Command {
    @Override
    public void execute(Context context) {
        Map<Integer, Thing> listShow = context.getLocalProductService().getAllItems();
        if (listShow.isEmpty()) {
            System.out.println("Empty list");
        } else {
            for (Map.Entry<Integer, Thing> thingEntry : listShow.entrySet()) {
                System.out.println(thingEntry.getValue());
            }
        }
    }
}
