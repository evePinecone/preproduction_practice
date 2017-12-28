package com.epam.preprod.roman_lutsenko.util;

public class ParseInputData {

    public static Integer phoneFromString(String string) {
        Integer phone;
        phone = Integer.parseInt(string.substring(1));
        return phone;
    }

}
