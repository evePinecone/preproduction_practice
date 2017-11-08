package com.epam.preprod.roman_lutsenko.task4.constants;

import com.epam.preprod.roman_lutsenko.task4.commands.Command;
import com.epam.preprod.roman_lutsenko.task4.commands.ExitCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.NoSuchCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.ShowCommand;

import java.util.Map;
import java.util.TreeMap;

public class CommandsContainer {

    private Map<String, Command> commandsList = new TreeMap<>();

    {
        //Here put elements.
        commandsList.put("1", new ShowCommand());
        commandsList.put("666", new NoSuchCommand());
        commandsList.put("exit", new ExitCommand());
    }

    public Command getCommand(String key){
        if(commandsList.containsKey(key) && key != null) {
            return commandsList.get(key);
        }
        return commandsList.get("666");
    }
}
