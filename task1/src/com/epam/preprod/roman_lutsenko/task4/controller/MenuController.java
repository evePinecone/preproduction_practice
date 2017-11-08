package com.epam.preprod.roman_lutsenko.task4.controller;

import com.epam.preprod.roman_lutsenko.task4.commands.Command;
import com.epam.preprod.roman_lutsenko.task4.constants.CommandsContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Scanner;

public class MenuController {

    public void menu(Context context) {
        Command command;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                context.showMenu();
                String choice = scanner.nextLine();
                command = (new CommandsContainer()).getCommand(choice);
                command.execute(context);
            }


        }
    }
}
