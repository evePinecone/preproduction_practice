package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.util.ParseInputData;
import com.epam.preprod.roman_lutsenko.util.ValidateInput;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constants.FieldsName.FORM_REGISTRATION_EMAIL;
import static com.epam.preprod.roman_lutsenko.constants.FieldsName.FORM_REGISTRATION_NAME;
import static com.epam.preprod.roman_lutsenko.constants.FieldsName.FORM_REGISTRATION_PASSWORD;
import static com.epam.preprod.roman_lutsenko.constants.FieldsName.FORM_REGISTRATION_PHONE;
import static com.epam.preprod.roman_lutsenko.constants.FieldsName.SESSION_CONTEXT;
import static com.epam.preprod.roman_lutsenko.constants.FieldsName.SESSION_ERR_MESS;
import static com.epam.preprod.roman_lutsenko.constants.FieldsName.TAG_CAPTCHA_INPUT_VALUE;
import static com.epam.preprod.roman_lutsenko.constants.Messages.REGISTRATION_DUPLICATE_USER;
import static com.epam.preprod.roman_lutsenko.constants.Messages.REGISTRATION_NON_VALID_FIELDS;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug(getClass() + Messages.STARTED);
        Context context = (Context) req.getServletContext().getAttribute(SESSION_CONTEXT);
        User user = initUserFromForm(req);
        if (isValidCaptcha(req, context)) {
            logger.debug("TELEPHONE " + req.getParameter(FORM_REGISTRATION_PHONE));
            if (containsUser(context, ParseInputData.phoneFromString((String) req.getParameter(FORM_REGISTRATION_PHONE)))) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_DUPLICATE_USER);
                resp.sendRedirect("registration");
            } else if (Objects.isNull(user)) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_NON_VALID_FIELDS);
                resp.sendRedirect("registration");
            } else {
                //TODO: insert user to database;
                resp.sendRedirect("index.jsp");
            }
        } else {
            resp.sendRedirect("registration");
        }
        logger.debug(getClass() + Messages.ENDED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("DO GET " + getServletName());

        Context context = (Context) req.getServletContext().getAttribute(SESSION_CONTEXT);
        context.getCaptchaService().addCaptcha(req, resp);
        ;

        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    private User initUserFromForm(HttpServletRequest request) {
        clearSessionFromUserFields(request);
        User user = new User();
        String field = (String) request.getParameter(FORM_REGISTRATION_NAME);
        if (Objects.nonNull(field) && ValidateInput.validName(field)) {
            user.setName(field);
            request.getSession().setAttribute(FORM_REGISTRATION_NAME, field);
            logger.debug(FORM_REGISTRATION_NAME + "valid");
        } else {
            logger.debug(FORM_REGISTRATION_NAME + "NON valid");
            user = null;
        }
        field = (String) request.getParameter(FORM_REGISTRATION_PHONE);
        if (Objects.nonNull(field) && ValidateInput.validPhone(field)) {
            if (Objects.nonNull(user)) {
                user.setPhone(ParseInputData.phoneFromString(field));
                logger.debug(FORM_REGISTRATION_PHONE + "valid");
            }
            request.getSession().setAttribute(FORM_REGISTRATION_PHONE, field);
        } else {
            logger.debug(FORM_REGISTRATION_PHONE + "NON valid");
            user = null;
        }
        field = (String) request.getParameter(FORM_REGISTRATION_EMAIL);
        if (Objects.nonNull(field) && ValidateInput.validEmail(field)) {
            if (Objects.nonNull(user)) {
                user.setEmail((String) request.getAttribute(FORM_REGISTRATION_EMAIL));
                logger.debug(FORM_REGISTRATION_EMAIL + "valid");
            }
            request.getSession().setAttribute(FORM_REGISTRATION_EMAIL, field);
        } else {
            logger.debug(FORM_REGISTRATION_EMAIL + "NON valid");
            user = null;
        }
        field = (String) request.getParameter(FORM_REGISTRATION_PASSWORD);
        if (Objects.nonNull(field) && ValidateInput.validPassword(field)) {
            if (Objects.nonNull(user)) {
                logger.debug(FORM_REGISTRATION_PASSWORD + "valid = " + field);
                user.setPassword(field);
            }
        } else {
            logger.debug(FORM_REGISTRATION_PASSWORD + "NON valid = " + field);
            user = null;
        }
        return user;
    }

    private boolean isValidCaptcha(HttpServletRequest request, Context context) {
        String captureValue = request.getParameter(TAG_CAPTCHA_INPUT_VALUE);
        return context.getCaptchaService().isCorrectCaptcha(request, captureValue);
    }

    private boolean containsUser(Context context, String phone) {
        UserService userService = context.getUserService();
        return userService.contains(phone);
    }

    private void clearSessionFromUserFields(HttpServletRequest request) {
        request.getSession().removeAttribute(SESSION_ERR_MESS);
        request.getSession().removeAttribute(FORM_REGISTRATION_NAME);
        request.getSession().removeAttribute(FORM_REGISTRATION_EMAIL);
        request.getSession().removeAttribute(FORM_REGISTRATION_PHONE);
    }
}
