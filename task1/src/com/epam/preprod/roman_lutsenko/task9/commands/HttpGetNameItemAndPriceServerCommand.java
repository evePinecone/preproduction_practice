package com.epam.preprod.roman_lutsenko.task9.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants;
import com.epam.preprod.roman_lutsenko.task9.util.ParseTcpRequest;

import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.task9.commands.TcpGetNameItemAndPriceServerCommand.NO_SUCH_ITEM_IN_SHOP;

public class HttpGetNameItemAndPriceServerCommand implements ServerCommand{
    @Override
    public String execute(Context context, String request) {
        //PARSE REQUEST
        Integer id = getIdFromRequest(request);
        StringBuilder response = new StringBuilder();
        Thing thing = context.getLocalProductService().get(id);
        if(Objects.isNull(thing)){
            return NO_SUCH_ITEM_IN_SHOP;
        }
        response.append("{name:");
        response.append(thing.getNameModel());
        response.append(", price:");
        response.append(thing.getPrice());
        response.append("}");
        return response.toString();
    }

    private Integer getIdFromRequest(String request) {
        String[] string = ParseTcpRequest.parseToRequestAndAttr(request);
        return Integer.valueOf(string[1]);
    }
}
