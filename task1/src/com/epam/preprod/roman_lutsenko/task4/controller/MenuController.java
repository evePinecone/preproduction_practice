package com.epam.preprod.roman_lutsenko.task4.controller;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.commands.Command;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.CommandsContainer;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.StrategyContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.context.StrategyContext;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.util.Scanner;

public class MenuController {

    public void menu(Context context) {
        Command command;
        StrategyContext strategyContext = new StrategyContext();
        CommandsContainer commandsContainer = new CommandsContainer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();
            command = commandsContainer.getCommand(choice);
            command.execute(context);
        }

    }

    public void showMenu() {
        System.out.println("\t1. Show all items");
        System.out.println("\t2. Add item to cart");
        System.out.println("\t3. Show the cart");
        System.out.println("\t4. By all items in cart.(Show total price order)");
        System.out.println("\t5. Show information about last five items in cart");
        System.out.println("\t6. Show orders between DateTime");
        System.out.println("\t7. Show nearest order");
        System.out.println("\t8. Add thing to catalog");
        System.out.println("\texit. End of program.");
    }



}