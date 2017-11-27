package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.services.FileSavable;

/**
 * Special Exit command. End of work with shop.
 */
public class ExitCommand implements Command {
    @Override
    public void execute(Context context) {
        System.err.println("End of program. GL!");
        ((FileSavable) context.getLocalProductService()).serializeProduct();
        System.exit(CommandConstants.EXIT_COMMAND_CODE);
    }
}