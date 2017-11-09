package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.List;

public class ShowAllProductsCommand implements Command {
    @Override
    public void execute(Context context) {
        List<Thing> listShow = context.getLocalProductService().getAllItems();
        if (listShow.isEmpty()) {
            System.out.println("Empty list");
        } else {
            context.getLocalProductService().show();
        }
    }
}
