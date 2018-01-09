package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.util.ValidateInput;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constants.Fields.FORM_REGISTRATION_EMAIL;
import static com.epam.preprod.roman_lutsenko.constants.Fields.FORM_REGISTRATION_NAME;
import static com.epam.preprod.roman_lutsenko.constants.Fields.FORM_REGISTRATION_PASSWORD;
import static com.epam.preprod.roman_lutsenko.constants.Fields.FORM_REGISTRATION_PHONE;
import static com.epam.preprod.roman_lutsenko.constants.Fields.INDEX_JSP;
import static com.epam.preprod.roman_lutsenko.constants.Fields.REGISTRATION_JSP;
import static com.epam.preprod.roman_lutsenko.constants.Fields.REGISTRATION_SERVLET;
import static com.epam.preprod.roman_lutsenko.constants.Fields.SESSION_CONTEXT;
import static com.epam.preprod.roman_lutsenko.constants.Fields.SESSION_ERR_MESS;
import static com.epam.preprod.roman_lutsenko.constants.Fields.TAG_CAPTCHA_INPUT_VALUE;
import static com.epam.preprod.roman_lutsenko.constants.Messages.REGISTRATION_DUPLICATE_USER;
import static com.epam.preprod.roman_lutsenko.constants.Messages.REGISTRATION_NON_VALID_FIELDS;

/**
 * Process registration form and check if user with this phone consist in User container.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final Logger LOG = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug(getClass() + Messages.STARTED);
        Context context = (Context) req.getServletContext().getAttribute(SESSION_CONTEXT);
        User user = getUserFromRequest(req);
        if (isValidCaptcha(req, context)) {
            if (containsUser(context, req.getParameter(FORM_REGISTRATION_PHONE))) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_DUPLICATE_USER);
                resp.sendRedirect(REGISTRATION_SERVLET);
            } else if (Objects.isNull(user)) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_NON_VALID_FIELDS);
                resp.sendRedirect(REGISTRATION_SERVLET);
            } else {
                //TODO: insert user to database;
                try {
                    context.getUserService().add(user);
                    LOG.debug("USER ADDED");
                } catch (UserDuplicateException e) {
                    LOG.debug(e.getMessage());
                }
                resp.sendRedirect(INDEX_JSP);
            }
        } else {
            resp.sendRedirect(REGISTRATION_SERVLET);
        }
        LOG.debug(getClass() + Messages.ENDED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug(Messages.GET_METHOD_START);

        Context context = (Context) req.getServletContext().getAttribute(SESSION_CONTEXT);
        context.getCaptchaService().addCaptcha(req, resp);

        req.getRequestDispatcher(REGISTRATION_JSP).forward(req, resp);
    }

    /**
     * Parse request into User entity and check if data is valid, if valid - set it to session.
     * @param request request from user.
     * @return User instance with setted fields or <b>null</b> if user cannot insert to user container.
     */
    //todo: Create UserRequestGetter
    private User getUserFromRequest(HttpServletRequest request) {
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
