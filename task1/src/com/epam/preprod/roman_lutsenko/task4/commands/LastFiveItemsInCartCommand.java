package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Map;

public class LastFiveItemsInCartCommand implements Command {
    @Override
    public void execute(Context context) {
       /* Map<Integer,Integer> map = context.getLocalAllCartAddingService();
        int lastIndexMap = map.size()-1;
        int counter = 0;
        while (lastIndexMap-- >= 0 && counter++ < 5) {
            System.out.println(map.get(lastIndexMap+1));
        }*/

        if (context.isEmptyAllCartAddingService()) {
            System.out.println("You did not add elements to the cart.");
        } else {
            int lastIndexMap = context.sizeAllCartAddingService();
            int counter = 0;
            while (lastIndexMap > 0 && counter < 5) {
            System.out.println(context.getLocalProductService(context.getThingIdByIndexInAllCartAddingItemsMap(lastIndexMap)));
                lastIndexMap--;
                counter++;
           }
        }
    }


}
