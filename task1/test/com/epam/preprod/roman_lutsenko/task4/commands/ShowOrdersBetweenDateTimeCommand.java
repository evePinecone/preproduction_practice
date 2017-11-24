package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Show all orders between two dates.
 */
public class ShowOrdersBetweenDateTimeCommand implements Command {
    @Override
    public void execute(Context context) {
        System.out.println("Enter begin date > ");
        LocalDateTime begin = InputUtil.readDateTime();
        System.out.println("Enter end date > ");
        LocalDateTime end = InputUtil.readDateTime();

        Map<LocalDateTime, Order> map = context.getLocalOrderService().getOrderMap();
        for (LocalDateTime localDateTime : map.keySet()) {
            if (localDateTime.isBefore(end) && localDateTime.isAfter(begin)) {
                System.out.println(map.get(localDateTime));
            }
        }
    }
}
