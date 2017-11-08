package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

public class ShowCartCommand implements Command {
    @Override
    public void execute(Context context) {
        context.showLocalCartService();
    }
}
