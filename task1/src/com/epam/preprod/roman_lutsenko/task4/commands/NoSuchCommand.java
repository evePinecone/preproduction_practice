package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

/**
 * Command to show on console that we write incorrect output.
 */
public class NoSuchCommand implements Command {

    @Override
    public void execute(Context context) {
        System.out.println("Incorrect command, gl hf");
    }
}
