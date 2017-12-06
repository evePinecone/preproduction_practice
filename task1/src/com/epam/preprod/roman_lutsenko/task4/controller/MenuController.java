package com.epam.preprod.roman_lutsenko.task4.controller;

import com.epam.preprod.roman_lutsenko.task4.commands.Command;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.CommandsContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.context.StrategyContext;

import java.util.Scanner;

public class MenuController {

    public void menu(Context context) {
        Command command;
        StrategyContext strategyContext = new StrategyContext();
        CommandsContainer commandsContainer = new CommandsContainer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            commandsContainer.showMenu();
            String choice = scanner.nextLine().trim();
            command = commandsContainer.getCommand(choice);
            command.execute(context);
        }

    }
}