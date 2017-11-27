package com.epam.preprod.roman_lutsenko.task5.chain.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class InputUtil {


    public static boolean confirmedInput(Scanner scanner) {
        Boolean valid = null;
        do {
            valid = ValidationUtil.confirmedInputValid(scanner.nextLine());
        } while(Objects.isNull(valid));
        return valid;
    }

    public static long dateInput(Scanner scanner) {
        Date valid = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        do {
            valid = ValidationUtil.dateValid(simpleDateFormat, scanner.nextLine());
        } while(Objects.isNull(valid));
        return valid.getTime();
    }
}
