package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

public class NoSuchServerCommand implements ServerCommand {
    @Override
    public String execute(Context context, String request) {
        System.err.println("No such command");
        return null;
    }
}
