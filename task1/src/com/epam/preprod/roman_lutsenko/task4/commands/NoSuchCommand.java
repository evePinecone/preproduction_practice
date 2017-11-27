package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task7.builder.LaptopRandomBuilder;

/**
 * Command to show on console that we write incorrect output.
 */
public class NoSuchCommand implements Command {

    @Override
    public void execute(Context context) {
        Laptop laptop = new Laptop();
        new LaptopRandomBuilder<>().build(laptop);
        System.out.println(laptop);
        System.out.println("Incorrect command");
    }
}
