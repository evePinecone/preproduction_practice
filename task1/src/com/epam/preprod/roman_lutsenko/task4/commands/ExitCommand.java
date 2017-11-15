package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

public class ExitCommand implements Command {
    @Override
    public void execute(Context context) {
        System.err.println("End of program. GL!");
        context.getLocalProductService().serializeProduct();
        System.exit(666);
    }
}
