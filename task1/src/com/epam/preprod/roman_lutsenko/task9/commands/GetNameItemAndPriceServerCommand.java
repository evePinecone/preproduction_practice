package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants;
import com.epam.preprod.roman_lutsenko.task9.util.ParseTcpRequest;

import java.util.Objects;

public class GetNameItemAndPriceServerCommand implements ServerCommand {

    private static final String NO_SUCH_ITEM_IN_SHOP = "No item with this id in shop";

    @Override
    public String execute(Context context, String request) {
        Integer id = getIdFromRequest(request);
        StringBuilder response = new StringBuilder();
        Thing thing = context.getLocalProductService().get(id);
        if(Objects.isNull(thing)){
            return NO_SUCH_ITEM_IN_SHOP;
        }
        response.append(thing.getNameModel());
        response.append(ServerCommandConstants.SEPARATOR_FOR_THING_PRICE);
        response.append(thing.getPrice());
        return response.toString();
    }

    private Integer getIdFromRequest(String request) {
        String[] string = ParseTcpRequest.parseToRequestAndAttr(request);
        return Integer.valueOf(string[1]);
    }
}
