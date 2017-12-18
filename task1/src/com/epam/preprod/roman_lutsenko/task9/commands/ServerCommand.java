package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

/**
 * Interface for commands working with server request.
 */
public interface ServerCommand {

    /**
     * Executes specified command for request.
     * @param context context of the shop.
     * @param request request for command/
     * @return response of server with formated output.
     */
    String execute(Context context, String request);
}
