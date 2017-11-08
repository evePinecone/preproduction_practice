package com.epam.preprod.roman_lutsenko.task4.commands;

public class NoSuchCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Incorrect command, gl hf");
    }
}
