package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

public class HttpGetCountServerCommand implements ServerCommand{
    @Override
    public String execute(Context context, String request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{count:").append(context.getLocalProductService().getAllItems().size()).append("}");
        return stringBuilder.toString();
    }
}
