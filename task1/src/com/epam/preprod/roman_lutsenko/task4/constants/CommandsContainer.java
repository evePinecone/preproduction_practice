package com.epam.preprod.roman_lutsenko.task4.constants;

import com.epam.preprod.roman_lutsenko.task4.commands.*;

import java.util.Map;
import java.util.TreeMap;

public class CommandsContainer {

    private Map<String, Command> commandsList = new TreeMap<>();

    {
        //Here put elements.
        commandsList.put("1", new ShowAllProductsCommand());
        commandsList.put("2", new AddProductToCartCommand());
        commandsList.put("3", new ShowCartCommand());
        commandsList.put("4", new MakeAnOrderCommand());
        commandsList.put("5", new LastFiveItemsInCartCommand());
        commandsList.put("6", new ShowOrdersBetweenDateTimeCommand());
        commandsList.put("7", new ShowNearestOrderCommand());
        commandsList.put("8", new AddThingCommand());
        commandsList.put("666", new NoSuchCommand());
        commandsList.put("exit", new ExitCommand());
    }

    public Command getCommand(String key) {
        if (commandsList.containsKey(key) && key != null) {
            return commandsList.get(key);
        }
        return commandsList.get("666");
    }
}
