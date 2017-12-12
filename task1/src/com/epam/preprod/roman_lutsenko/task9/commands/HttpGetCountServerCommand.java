package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

/**
 * Command for count of all items in shop.
 */
public class HttpGetCountServerCommand implements ServerCommand {

    @Override
    public String execute(Context context, String request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{count:").append(context.getLocalProductService().getAllItems().size()).append("}");
        return stringBuilder.toString();
    }
}
