package com.epam.preprod.roman_lutsenko.task9.constants;

/**
 * Constants for commands.
 */
public class ServerCommandConstants {
    /**
     * Exit command code for ExitCommand.class.
     */
    public static final  int EXIT_COMMAND_CODE = 666;

    /**
     * Separates thing with it number in cart for ShowCartCommand.class.
     */
    public static final String SEPARATOR_FOR_THING_PIECES = " | pcs:";

    public static final String SERVER_COMMAND_ID_GET_COUNT_ITEMS = "1";
    public static final String SERVER_COMMAND_ID_NO_SUCH = "noSuchCommand";

    public static final String ENTITY_ID_LAPTOP = "1";
    public static final String ENTITY_ID_DESKTOP = "2";
    public static final String ENTITY_ID_FITNESS_BRACELET = "3";
    public static final String ENTITY_ID_NO_SUCH_ENTITY = "noSuchEntity";


}