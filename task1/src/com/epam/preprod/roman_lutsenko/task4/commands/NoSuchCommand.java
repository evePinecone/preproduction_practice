package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import javax.crypto.Cipher;

public class NoSuchCommand implements Command{

    @Override
    public void execute(Context context) {
        System.out.println("Incorrect command, gl hf");
    }
}
