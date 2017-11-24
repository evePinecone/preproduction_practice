package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

/**
 * Interface for commands in our shop.
 */
public interface Command {

    /**
     * Create a logic in implemented class.
     *
     * @param context contains all services and set logic of program.
     */
    void execute(Context context);
}
