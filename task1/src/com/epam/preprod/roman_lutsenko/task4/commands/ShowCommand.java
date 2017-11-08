package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.InnerThingsDAO;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command {
    @Override
    public void execute() {

        System.out.println("Empty list");
    }
}
