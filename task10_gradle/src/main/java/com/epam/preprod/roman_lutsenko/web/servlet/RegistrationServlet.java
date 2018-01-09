package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.service.UserService;
import com.epam.preprod.roman_lutsenko.util.UserExtractor;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constant.Fields.FORM_REGISTRATION_PHONE;
import static com.epam.preprod.roman_lutsenko.constant.Fields.INDEX_JSP;
import static com.epam.preprod.roman_lutsenko.constant.Fields.REGISTRATION_JSP;
import static com.epam.preprod.roman_lutsenko.constant.Fields.REGISTRATION_SERVLET;
import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_CONTEXT;
import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_ERR_MESS;
import static com.epam.preprod.roman_lutsenko.constant.Fields.TAG_CAPTCHA_INPUT_VALUE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.REGISTRATION_DUPLICATE_USER;
import static com.epam.preprod.roman_lutsenko.constant.Messages.REGISTRATION_NON_VALID_FIELDS;

/**
 * Process registration form and check if user with this phone consist in User container.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final Logger LOG = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.debug(getClass() + Messages.STARTED);
        Context context = (Context) req.getServletContext().getAttribute(SESSION_CONTEXT);
        User user = UserExtractor.extractUserFromRequest(req);
        if (isValidCaptcha(req, context)) {
            if (containsUser(context, req.getParameter(FORM_REGISTRATION_PHONE))) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_DUPLICATE_USER);
                resp.sendRedirect(REGISTRATION_SERVLET);
            } else if (Objects.isNull(user)) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_NON_VALID_FIELDS);
                resp.sendRedirect(REGISTRATION_SERVLET);
            } else {
                try {
                    context.getUserService().add(user);
                    LOG.debug("USER ADDED");
                } catch (UserDuplicateException e) {
                    LOG.debug(e.getMessage());
                    resp.sendRedirect(REGISTRATION_SERVLET);
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


    private boolean isValidCaptcha(HttpServletRequest request, Context context) {
        String captureValue = request.getParameter(TAG_CAPTCHA_INPUT_VALUE);
        return context.getCaptchaService().isCorrectCaptcha(request, captureValue);
    }

    private boolean containsUser(Context context, String phone) {
        UserService userService = context.getUserService();
        return userService.contains(phone);
    }

}
