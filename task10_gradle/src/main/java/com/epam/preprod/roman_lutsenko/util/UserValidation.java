package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.entity.User;

import java.util.HashSet;
import java.util.Set;

import static com.epam.preprod.roman_lutsenko.constant.Fields.*;
import static com.epam.preprod.roman_lutsenko.util.ValidateInput.*;

public class UserValidation {

    /**
     * Check if setted fields valid.
     *
     * @param user User with setted fields.
     * @return Set<String> with invalid fields.
     */
    public static Set<String> validateFields(User user) {
        Set<String> set = new HashSet<>();
        if (!validName(user.getName())) {
            set.add(FORM_REGISTRATION_NAME);
        }
        if (!validEmail(user.getEmail())) {
            set.add(FORM_REGISTRATION_EMAIL);
        }
        if (!validPhone(user.getPhone())) {
            set.add(FORM_REGISTRATION_PHONE);
        }
        if (!validName(user.getPassword())) {
            set.add(FORM_REGISTRATION_PASSWORD);
        }
        return set;
    }
}
