package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

public class LastFiveItemsInCartCommand implements Command {
    @Override
    public void execute(Context context) {
        if (context.getLocalAllCartAddingService().isEmpty()) {
            System.out.println("You did not add elements to the cart.");
        } else {
            int lastIndexMap = context.getLocalAllCartAddingService().size();
            int counter = 0;
            while (lastIndexMap > 0 && counter < 5) {
                System.out.println(context.getLocalProductService().get(
                        context.getLocalAllCartAddingService().getThingIdByIndexInCartItemsMap(lastIndexMap)));
                lastIndexMap--;
                counter++;
            }
        }
    }


}
