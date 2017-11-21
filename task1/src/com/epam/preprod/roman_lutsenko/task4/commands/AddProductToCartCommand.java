package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Scanner;

/**
 * Add product from catalog to cart command.
 * Adding elemetn saved to cache.
 */
public class AddProductToCartCommand implements Command {
    @Override
    public void execute(Context context) {
        System.out.println("Enter id Thing to put to cart, or type \"back\" to go back.");
        context.getLocalProductService().show();
        Scanner scanner = new Scanner(System.in);
        boolean flagCorrectInput = true;
        do {
            String inputId = scanner.nextLine().trim();
            if (inputId.equals("back")) {
                break;
            }
            try {
                int thingId = Integer.parseInt(inputId);
                flagCorrectInput = false;
                if (context.getLocalProductService().get(thingId) != null) {
                    context.getLocalCartService().add(thingId);
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number format. Please type an Id number.");
            }
        }
        while (flagCorrectInput);
    }

}
