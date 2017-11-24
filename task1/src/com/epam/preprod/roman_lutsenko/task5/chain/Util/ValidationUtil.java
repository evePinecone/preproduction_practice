package com.epam.preprod.roman_lutsenko.task5.chain.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ValidationUtil {

    public static Boolean confirmedInputValid(String string) {
        string = string.trim();
        if (Objects.equals(string, "1")) {
            return true;
        } else if (Objects.equals(string, "0")) {
            return false;
        }
        System.out.println("Incorrect choose, please write 1 or 0");
        return null;
    }

    public static Date dateValid(SimpleDateFormat simpleDateFormat, String string) {
        Date valid = null;
        try {
            valid = simpleDateFormat.parse(string);
        } catch (ParseException e) {
            System.out.println("Incorrect data format");
            return null;
        }
        return valid;
    }
}
