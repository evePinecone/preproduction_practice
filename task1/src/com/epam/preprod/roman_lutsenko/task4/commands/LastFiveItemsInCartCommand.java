package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Map;

/**
 * Show to console last five items, that was added to the cart.
 * This five items is a cache cart.
 */
public class LastFiveItemsInCartCommand implements Command {
    @Override
    public void execute(Context context) {
        Map<Integer, Integer> cacheAdd = context.getLocalCartService().getCacheOfLastFiveAddings();
        if (cacheAdd.size() == 0) {
            System.out.println("You did not put elements to the cart.");
        } else {
            for (Map.Entry<Integer, Integer> entry : cacheAdd.entrySet()) {
                System.out.println(context.getLocalProductService().get(entry.getValue()));
            }
        }
    }


}
