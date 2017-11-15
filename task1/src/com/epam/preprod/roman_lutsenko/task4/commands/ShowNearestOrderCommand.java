package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.util.Util;

import java.time.LocalDateTime;
import java.util.Map;

public class ShowNearestOrderCommand implements Command {
    @Override
    public void execute(Context context) {
        LocalDateTime dateToSearch = Util.readDateTime();

        Map<LocalDateTime, Order> map = context.getLocalOrderService().getOrderMap();

        LocalDateTime nearestDateTime = LocalDateTime.now(); //= context.getLocalOrderService().getOrder(map.keySet().);
        int nearestCompareResult = 0;
        for (LocalDateTime tempLocalDateTime : map.keySet()) {
            nearestCompareResult = tempLocalDateTime.compareTo(dateToSearch);
            nearestDateTime = tempLocalDateTime;
            break;
        }

        for (LocalDateTime tempLocalDateTime : map.keySet()) {
            int compareTo = tempLocalDateTime.compareTo(dateToSearch);
            if (Math.abs(compareTo) < nearestCompareResult) {
                nearestDateTime = tempLocalDateTime;
                nearestCompareResult = compareTo;
            }
        }
        System.out.println("Nearest order > " + context.getLocalOrderService().getOrder(nearestDateTime));
    }
}
