package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

public interface ServerCommand {

    String execute(Context context, String request);
}
