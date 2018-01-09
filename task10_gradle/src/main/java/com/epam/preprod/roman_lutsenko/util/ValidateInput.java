package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.constant.Messages;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public final class ValidateInput {

    private ValidateInput(){
        throw new UnsupportedOperationException();
    }

    private static final Logger logger = Logger.getLogger(ValidateInput.class);

    private static final String NAME_REGEXP = "^\\w{3,}$";
    private static final String EMAIL_REGEXP = "^[A-z0-9._-]+@[A-z0-9.-]+\\.[A-z]{2,4}$";
    private static final String PHONE_REGEXP = "^\\+\\d{9,12}$";
    private static final String PASSWORD_REGEXP = "^.{8,}$";

    private static final Pattern PATTERN_NAME = Pattern.compile(NAME_REGEXP);
    private static final Pattern PATTERN_EMAIL = Pattern.compile(EMAIL_REGEXP);
    private static final Pattern PATTERN_PHONE = Pattern.compile(PHONE_REGEXP);
    private static final Pattern PATTERN_PASSWORD = Pattern.compile(PASSWORD_REGEXP);

    public static boolean validName(String name) {
        logger.info(Messages.VALID_BEGIN_NAME);
        return PATTERN_NAME.matcher(name).matches();
    }
    public static boolean validEmail(String email) {
        logger.info(Messages.VALID_BEGIN_EMAIL);
        return PATTERN_EMAIL.matcher(email).matches();
    }
    public static boolean validPhone(String phone) {
        logger.info(Messages.VALID_BEGIN_PHONE);
        return PATTERN_PHONE.matcher(phone).matches();
    }
    public static boolean validPassword(String password) {
        logger.info(Messages.VALID_BEGIN_PASSWORD);
        return PATTERN_PASSWORD.matcher(password).matches();
    }
}
