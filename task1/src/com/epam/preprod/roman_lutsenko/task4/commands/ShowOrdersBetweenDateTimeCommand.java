package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.util.Util;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

public class ShowOrdersBetweenDateTimeCommand implements Command {
    @Override
    public void execute(Context context) {
        System.out.println("Enter begin date > ");
        LocalDateTime begin = Util.readDateTime();
        System.out.println("Enter end date > ");
        LocalDateTime end = Util.readDateTime();

        Map<LocalDateTime, Order> map = context.getLocalOrderService().getOrderMap();
        for (LocalDateTime localDateTime : map.keySet()) {
            if (localDateTime.isBefore(end) && localDateTime.isAfter(begin)) {
                System.out.println(map.get(localDateTime));
            }
        }
    }
}
