package com.epam.preprod.roman_lutsenko.task4.commands;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.err.println("End of program. GL!");
        System.exit(666);
    }
}
