package com.epam.preprod.roman_lutsenko.task4.controller;

import com.epam.preprod.roman_lutsenko.task4.commands.Command;
import com.epam.preprod.roman_lutsenko.task4.constants.CommandsContainer;

import java.util.Scanner;

public class MenuController {

    public void menu() {

        Command command;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String choise;
                System.out.println("\t1. Show all items");
                System.out.println("\t2. Add item to cart");
                System.out.println("\t3. Show the cart");
                System.out.println("\t4. By all items in cart.(Show total price order)");
                System.out.println("\t5. Show information about last five items in cart");
                System.out.println("\texit. End of program.");
                choise = scanner.nextLine();
                command = (new CommandsContainer()).getCommand(choise);
                command.execute();
            }


        }
    }
}
