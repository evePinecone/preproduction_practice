package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

import static com.epam.preprod.roman_lutsenko.constant.Fields.*;

public class UserSessionSaver {

    public static final Logger LOGGER = Logger.getLogger(UserSessionSaver.class);

    /**
     * Set valid user fields to session, for avoid duplicate input.
     * @param request request from client
     * @param user User extracted from form.
     */
    public static void setValidFieldsToSession(HttpServletRequest request, User user) {
        clearSessionFromUserFields(request);
        Set<String> invalidFields = UserValidation.validateFields(user);
        if (!invalidFields.contains(FORM_REGISTRATION_NAME)) {
            request.getSession().setAttribute(FORM_REGISTRATION_NAME, user.getName());
        }
        if (!invalidFields.contains(FORM_REGISTRATION_EMAIL)) {
            request.getSession().setAttribute(FORM_REGISTRATION_EMAIL, user.getEmail());
        }
        if (!invalidFields.contains(FORM_REGISTRATION_PHONE)) {
            request.getSession().setAttribute(FORM_REGISTRATION_PHONE, user.getPhone());
        }
    }

    public static void clearSessionFromUserFields(HttpServletRequest request) {
        request.getSession().removeAttribute(SESSION_ERR_MESS);
        request.getSession().removeAttribute(FORM_REGISTRATION_NAME);
        request.getSession().removeAttribute(FORM_REGISTRATION_EMAIL);
        request.getSession().removeAttribute(FORM_REGISTRATION_PHONE);
    }
}
