package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Scanner;

public class AddProductCommand implements Command {
    @Override
    public void execute(Context context) {
        System.out.println("Enter id Thing to add to cart, or type \"back\" to go back.");
        context.getLocalProductService().show();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (!string.equals("back")) {
            int thingId = Integer.parseInt(string);
            if (context.getLocalProductService().get(thingId) != null) {
                context.getLocalCartService().add(thingId);
                context.getLocalAllCartAddingService().add(thingId);
            }
        }
    }

}
