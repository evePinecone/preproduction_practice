package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.epam.preprod.roman_lutsenko.constant.Fields.*;
import static com.epam.preprod.roman_lutsenko.constant.Fields.FORM_REGISTRATION_PASSWORD;

public class UserExtractor {

    private static final Logger LOG = Logger.getLogger(UserExtractor.class);

    private UserExtractor() {
        throw new UnsupportedOperationException();
    }

    /**
     * Parse request into User entity and check if data is valid, if valid - set it to session.
     * @param request request from user.
     * @return User instance with setted fields or <b>null</b> if user cannot insert to user container.
     */
    public static User extractUserFromRequest(HttpServletRequest request) {
        clearSessionFromUserFields(request);
        User user = new User();
        String field = (String) request.getParameter(FORM_REGISTRATION_NAME);
        if (Objects.nonNull(field) && ValidateInput.validName(field)) {
            user.setName(field);
            request.getSession().setAttribute(FORM_REGISTRATION_NAME, field);
            LOG.debug(FORM_REGISTRATION_NAME + " valid");
        } else {
            LOG.debug(FORM_REGISTRATION_NAME + " NON valid");
            user = null;
        }
        field = (String) request.getParameter(FORM_REGISTRATION_PHONE);
        if (Objects.nonNull(field) && ValidateInput.validPhone(field)) {
            if (Objects.nonNull(user)) {
                user.setPhone(field);
                LOG.debug(FORM_REGISTRATION_PHONE + " valid");
            }
            request.getSession().setAttribute(FORM_REGISTRATION_PHONE, field);
        } else {
            LOG.debug(FORM_REGISTRATION_PHONE + " NON valid");
            user = null;
        }
        field = (String) request.getParameter(FORM_REGISTRATION_EMAIL);
        if (Objects.nonNull(field) && ValidateInput.validEmail(field)) {
            if (Objects.nonNull(user)) {
                user.setEmail(field);
                LOG.debug(FORM_REGISTRATION_EMAIL + " valid");
            }
            request.getSession().setAttribute(FORM_REGISTRATION_EMAIL, field);
        } else {
            LOG.debug(FORM_REGISTRATION_EMAIL + " NON valid");
            user = null;
        }
        field = (String) request.getParameter(FORM_REGISTRATION_PASSWORD);
        if (Objects.nonNull(field) && ValidateInput.validPassword(field)) {
            if (Objects.nonNull(user)) {
                LOG.debug(FORM_REGISTRATION_PASSWORD + " valid");
                user.setPassword(field);
            }
        } else {
            LOG.debug(FORM_REGISTRATION_PASSWORD + " NON valid");
            user = null;
        }
        return user;
    }

    private static void clearSessionFromUserFields(HttpServletRequest request) {
        request.getSession().removeAttribute(SESSION_ERR_MESS);
        request.getSession().removeAttribute(FORM_REGISTRATION_NAME);
        request.getSession().removeAttribute(FORM_REGISTRATION_EMAIL);
        request.getSession().removeAttribute(FORM_REGISTRATION_PHONE);
    }

    public static User extractUserFromResultSer(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(Fields.ID));
        user.setName(resultSet.getString(Fields.USER_NAME));
        user.setEmail(resultSet.getString(Fields.USER_EMAIL));
        user.setPhone(resultSet.getString(Fields.USER_PHONE));
        user.setPassword(resultSet.getString(Fields.USER_PASSWORD));
        return user;
    }

}
