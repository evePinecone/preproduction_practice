package com.epam.preprod.roman_lutsenko.task9.constants.container;

import com.epam.preprod.roman_lutsenko.task9.commands.HttpGetCountServerCommand;
import com.epam.preprod.roman_lutsenko.task9.commands.HttpGetNameItemAndPriceServerCommand;
import com.epam.preprod.roman_lutsenko.task9.commands.TcpGetCountServerCommand;
import com.epam.preprod.roman_lutsenko.task9.commands.TcpGetNameItemAndPriceServerCommand;
import com.epam.preprod.roman_lutsenko.task9.commands.NoSuchServerCommand;
import com.epam.preprod.roman_lutsenko.task9.commands.ServerCommand;

import java.util.Map;
import java.util.TreeMap;

import static com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants.SERVER_COMMAND_ID_GET_COUNT_ITEMS;
import static com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants.SERVER_COMMAND_ID_GET_NAME_ITEM_AND_PRICE;
import static com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants.SERVER_COMMAND_ID_HTTP_GET_COUNT_ITEMS;
import static com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants.SERVER_COMMAND_ID_HTTP_GET_NAME_ITEM_AND_PRICE;
import static com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants.SERVER_COMMAND_ID_NO_SUCH;


public class ServerCommandsContainer {
    private Map<String, ServerCommand> commandsList = new TreeMap<>();

    public ServerCommandsContainer() {
        //Here put elements.
        commandsList.put(SERVER_COMMAND_ID_GET_COUNT_ITEMS, new TcpGetCountServerCommand());
        commandsList.put(SERVER_COMMAND_ID_GET_NAME_ITEM_AND_PRICE, new TcpGetNameItemAndPriceServerCommand());

        //HTTP commands
        commandsList.put(SERVER_COMMAND_ID_HTTP_GET_COUNT_ITEMS, new HttpGetCountServerCommand());
        commandsList.put(SERVER_COMMAND_ID_HTTP_GET_NAME_ITEM_AND_PRICE, new HttpGetNameItemAndPriceServerCommand());

        commandsList.put(SERVER_COMMAND_ID_NO_SUCH, new NoSuchServerCommand());
    }

    public ServerCommand getCommand(String key) {
        if (commandsList.containsKey(key)) {
            return commandsList.get(key);
        }
        return commandsList.get(SERVER_COMMAND_ID_NO_SUCH);
    }


}
