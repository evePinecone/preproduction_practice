package com.epam.preprod.roman_lutsenko.task4.constants.containers;

import com.epam.preprod.roman_lutsenko.task4.commands.AddProductToCartCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.AddThingCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.AddThingWithReflectionCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.Command;
import com.epam.preprod.roman_lutsenko.task4.commands.ExitCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.LastFiveItemsInCartCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.MakeAnOrderCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.NoSuchCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.ShowAllProductsCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.ShowCartCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.ShowNearestOrderCommand;
import com.epam.preprod.roman_lutsenko.task4.commands.ShowOrdersBetweenDateTimeCommand;

import java.util.Map;
import java.util.TreeMap;

import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_ADD_PRODUCT_TO_CART;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_ADD_THING;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_ADD_THING_REFLECTION;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_EXIT;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_LAST_FIVE_ITEMS_IN_CART;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_MAKE_AN_ORDER;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_NO_SUCH;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_SHOW_ALL_PRODUCTS;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_SHOW_CART;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_SHOW_NEAREST_ORDER;
import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.COMMAND_ID_SHOW_ORDERS_BETWEEN_DATE_TIME;

/**
 * container for commands in menu.
 */
public class CommandsContainer {

    private Map<String, Command> commandsList = new TreeMap<>();

    public CommandsContainer() {
        //Here put elements.
        commandsList.put(COMMAND_ID_SHOW_ALL_PRODUCTS, new ShowAllProductsCommand());
        commandsList.put(COMMAND_ID_ADD_PRODUCT_TO_CART, new AddProductToCartCommand());
        commandsList.put(COMMAND_ID_SHOW_CART, new ShowCartCommand());
        commandsList.put(COMMAND_ID_MAKE_AN_ORDER, new MakeAnOrderCommand());
        commandsList.put(COMMAND_ID_LAST_FIVE_ITEMS_IN_CART, new LastFiveItemsInCartCommand());
        commandsList.put(COMMAND_ID_SHOW_ORDERS_BETWEEN_DATE_TIME, new ShowOrdersBetweenDateTimeCommand());
        commandsList.put(COMMAND_ID_SHOW_NEAREST_ORDER, new ShowNearestOrderCommand());
        commandsList.put(COMMAND_ID_NO_SUCH, new NoSuchCommand());
        commandsList.put(COMMAND_ID_EXIT, new ExitCommand());
        commandsList.put(COMMAND_ID_ADD_THING, new AddThingCommand());
        commandsList.put(COMMAND_ID_ADD_THING_REFLECTION, new AddThingWithReflectionCommand());
    }

    public Command getCommand(String key) {
        if (commandsList.containsKey(key)) {
            return commandsList.get(key);
        }
        return commandsList.get(COMMAND_ID_NO_SUCH);
    }

    public void showMenu() {
        System.out.println("\t1. Show all items");
        System.out.println("\t2. Add item to cart");
        System.out.println("\t3. Show the cart");
        System.out.println("\t4. By all items in cart.(Show total price order)");
        System.out.println("\t5. Show information about last five items in cart");
        System.out.println("\t6. Show orders between DateTime");
        System.out.println("\t7. Show nearest order");
        System.out.println("\t8. Add thing to catalog");
        System.out.println("\t9. Add thing with reflection to catalog");
        System.out.println("\texit. End of program.");
    }
}
