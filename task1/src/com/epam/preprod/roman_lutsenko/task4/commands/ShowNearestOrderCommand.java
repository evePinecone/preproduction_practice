package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.entities.Order;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Show nearest order to input date.
 */

public class ShowNearestOrderCommand implements Command {
    @Override
    public void execute(Context context) {
        LocalDateTime dateToSearch = InputUtil.readDateTime();

        Map<LocalDateTime, Order> map = context.getLocalOrderService().getOrderMap();
        LocalDateTime nearHigh = ((NavigableMap<LocalDateTime, Order>) map).ceilingKey(dateToSearch);
        LocalDateTime nearLow = ((NavigableMap<LocalDateTime, Order>) map).floorKey(dateToSearch);

        if (nearHigh == null ^ nearLow == null) {
            LocalDateTime dateToPrint = nearHigh == null ? nearLow : nearHigh;
            System.out.println(context.getLocalOrderService().getOrder(dateToPrint));
        } else if (nearHigh == null && nearLow == null) {
            System.out.println("No orders!");
        } else {
            LocalDateTime dateToPrint = nearHigh.compareTo(dateToSearch) < nearHigh.compareTo(dateToSearch) ? nearLow : nearLow;
            System.out.println(context.getLocalOrderService().getOrder(dateToPrint));
        }
    }
}
