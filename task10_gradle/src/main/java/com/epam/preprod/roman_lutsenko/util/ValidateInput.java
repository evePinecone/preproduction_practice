package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class ValidateInput {
    private static final Logger logger = Logger.getLogger(ValidateInput.class);

   //todo: //pattern to const
    public static boolean validName(String name) {
        logger.info(Messages.VALID_BEGIN_NAME);
        Pattern pattern = Pattern.compile("^\\w{3,}$");
        return pattern.matcher(name).matches();
    }
    public static boolean validEmail(String email) {
        logger.info(Messages.VALID_BEGIN_EMAIL);
        Pattern pattern = Pattern.compile("^[A-z0-9._-]+@[A-z0-9.-]+\\.[A-z]{2,4}$");
        return pattern.matcher(email).matches();
    }
    public static boolean validPhone(String phone) {
        logger.info(Messages.VALID_BEGIN_PHONE);
        Pattern pattern = Pattern.compile("^\\+\\d{9,12}$");
        return pattern.matcher(phone).matches();
    }
    public static boolean validPassword(String password) {
        logger.info(Messages.VALID_BEGIN_PASSWORD);
        Pattern pattern = Pattern.compile(".{8,}");
        return pattern.matcher(password).matches();
    }
}
