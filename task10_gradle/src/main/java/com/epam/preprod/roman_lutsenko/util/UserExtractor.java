package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;

import static com.epam.preprod.roman_lutsenko.constant.Fields.*;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ERR_EXTRACTION_USER_FROM_RESULT_SET;
import static com.epam.preprod.roman_lutsenko.util.UserSessionSaver.clearSessionFromUserFields;
import static com.epam.preprod.roman_lutsenko.util.UserSessionSaver.setValidFieldsToSession;
import static com.epam.preprod.roman_lutsenko.util.UserValidation.validateFields;

public class UserExtractor {

    private static final Logger LOG = Logger.getLogger(UserExtractor.class);

    private UserExtractor() {
        throw new UnsupportedOperationException();
    }

    /**
     * Parse request into User entity. And check if password and password confirm are equals.
     * Returns user with setted fields, if fields are setted in request, and passwords equals.
     *
     * @param request request from user.
     * @return User instance with setted fields.
     */
    public static User extractUserFromRequest(HttpServletRequest request) {
        User user = new User();
        String field = request.getParameter(FORM_REGISTRATION_NAME);
        if (Objects.nonNull(field)) {
            user.setName(field);
        }
        field = request.getParameter(FORM_REGISTRATION_PHONE);
        if (Objects.nonNull(field)) {
            user.setPhone(field);
        }
        field = request.getParameter(FORM_REGISTRATION_EMAIL);
        if (Objects.nonNull(field)) {
            user.setEmail(field);
        }
        field = request.getParameter(FORM_REGISTRATION_PASSWORD);
        String passwordConfirm = request.getParameter(FORM_REGISTRATION_PASSWORD_CONFIRM);
        if (Objects.nonNull(field) && field.equals(passwordConfirm)) {
            user.setPassword(field);
        }
        return user;
    }


    public static User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            return null;
        }
        User user = new User();
        try {
            user.setId(resultSet.getInt(Fields.ID));
            user.setName(resultSet.getString(Fields.USER_NAME));
            user.setEmail(resultSet.getString(Fields.USER_EMAIL));
            user.setPhone(resultSet.getString(Fields.USER_PHONE));
            user.setPassword(resultSet.getString(Fields.USER_PASSWORD));
        } catch (SQLException e) {
            LOG.error(ERR_EXTRACTION_USER_FROM_RESULT_SET, e);
            throw e;
        }
        return user;
    }

    public static String phoneNumbers(String phone) {
        return phone.substring(1);
    }
}
