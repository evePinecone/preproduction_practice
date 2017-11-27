package com.epam.preprod.roman_lutsenko.task4.constants.containers;

import com.epam.preprod.roman_lutsenko.task4.commands.*;

import java.util.Map;
import java.util.TreeMap;

import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.*;

/**
 * Container for commands in menu.
 */
public class CommandsContainer {

    private Map<String, Command> commandsList = new TreeMap<>();

    public CommandsContainer(){
        //Here put elements.
        commandsList.put(COMMAND_ID_SHOW_ALL_PRODUCTS, new ShowAllProductsCommand());
        commandsList.put(COMMAND_ID_ADD_PRODUCT_TO_CART_COMMAND, new AddProductToCartCommand());
        commandsList.put(COMMAND_ID_SHOW_CART_COMMAND, new ShowCartCommand());
        commandsList.put(COMMAND_ID_MAKE_AN_ORDER, new MakeAnOrderCommand());
        commandsList.put(COMMAND_ID_LAST_FIVE_ITEMS_IN_CART, new LastFiveItemsInCartCommand());
        commandsList.put(COMMAND_ID_SHOW_ORDERS_BETWEEN_DATE_TIME, new ShowOrdersBetweenDateTimeCommand());
        commandsList.put(COMMAND_ID_SHOW_NEAREST_ORDER_COMMAND, new ShowNearestOrderCommand());
        commandsList.put(COMMAND_ID_NO_SUCH_COMMAND, new NoSuchCommand());
        commandsList.put(COMMAND_ID_EXIT_COMMAND, new ExitCommand());
        commandsList.put(COMMAND_ID_ADD_THING_COMMAND, new AddThingCommand());
    }

    public Command getCommand(String key) {
        if (commandsList.containsKey(key)) {
            return commandsList.get(key);
        }
        return commandsList.get(COMMAND_ID_NO_SUCH_COMMAND);
    }
}
