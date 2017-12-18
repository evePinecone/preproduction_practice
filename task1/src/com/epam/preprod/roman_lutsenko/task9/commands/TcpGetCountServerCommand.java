package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

/**
 * TCP interpretation of command get_count.
 */
public class TcpGetCountServerCommand implements ServerCommand {

    @Override
    public String execute(Context context, String request) {
        return "Number of elements in shop = " +
                context.getLocalProductService().getAllItems().size();
    }
}
