package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.task9.commands.TcpGetNameItemAndPriceServerCommand.NO_SUCH_ITEM_IN_SHOP;
import static com.epam.preprod.roman_lutsenko.task9.util.ParseHttpRequest.extract;

/**
 * HTTP interpretation of get_item command.
 */
public class HttpGetNameItemAndPriceServerCommand implements ServerCommand {

    private static final String NO_SUCH_ELEMENT = "No element with such ID";
    private static final String GET_INFO_PARAMETER = "get_info=";

    @Override
    public String execute(Context context, String request) {
        String result = extract(request, GET_INFO_PARAMETER, " ");
        if (Objects.isNull(result)) {
            return NO_SUCH_ELEMENT;
        }
        Integer id = Integer.parseInt(result);
        StringBuilder response = new StringBuilder();
        Thing thing = context.getLocalProductService().get(id);
        if (Objects.isNull(thing)) {
            return NO_SUCH_ITEM_IN_SHOP;
        }
        response.append("{name:").append(thing.getNameModel()).append(", price:")
                .append(thing.getPrice()).append("}");
        return response.toString();
    }

}
