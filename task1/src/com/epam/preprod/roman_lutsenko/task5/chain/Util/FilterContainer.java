package com.epam.preprod.roman_lutsenko.task5.chain.Util;

import com.epam.preprod.roman_lutsenko.task5.chain.filters.DateFilter;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.ExtensionFilter;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.FileNameFilter;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.FilterInterface;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.SizeFilter;

import java.util.Scanner;

public class FilterContainer {

    public FilterInterface filterByName(Scanner scanner, FilterInterface filter) {
        System.out.println("Filter by name? 1/0");
        if (InputUtil.confirmedInput(scanner)) {
            System.out.println("Enter file name >");
            String fileName = scanner.nextLine();
            return new FileNameFilter(filter, fileName);
        }
        return filter;
    }

    public FilterInterface filterByExtencion(Scanner scanner, FilterInterface filter) {
        System.out.println("Filter by extension? 1/0");
        if (InputUtil.confirmedInput(scanner)) {
            System.out.println("Enter extension >");
            String extension = scanner.nextLine();
            return filter = new ExtensionFilter(filter, extension);
        }
        return filter;
    }

    public FilterInterface filterBySize(Scanner scanner, FilterInterface filter) {
        System.out.println("Filter by Size? 1/0");
        if (InputUtil.confirmedInput(scanner)) {
            System.out.println("Enter min size >");
            long minSize = Long.parseLong(scanner.nextLine());
            System.out.println("Enter min size >");
            long maxSize = Long.parseLong(scanner.nextLine());
            filter = new SizeFilter(filter, minSize, maxSize);
        }
        return filter;
    }

    public FilterInterface filterByDate(Scanner scanner, FilterInterface filter) {
        System.out.println("Filter by date? 1/0");
        if (InputUtil.confirmedInput(scanner)) {
            System.out.println("From, in format yyyy-MM-dd >");
            long dateMin = InputUtil.dateInput(scanner);
            System.out.println("To, in format yyyy-MM-dd >");
            long dateMax = InputUtil.dateInput(scanner);
            filter = new DateFilter(filter, dateMin, dateMax);
        }
        return filter;
    }

}
