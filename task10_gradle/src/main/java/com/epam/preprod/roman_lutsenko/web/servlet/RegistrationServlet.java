package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.util.UserExtractor;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Set;

import static com.epam.preprod.roman_lutsenko.constant.Fields.*;
import static com.epam.preprod.roman_lutsenko.constant.Messages.ERR_USER_WITH_SUCH_PHONE_REGISTERED;
import static com.epam.preprod.roman_lutsenko.constant.Messages.REGISTRATION_NON_VALID_FIELDS;
import static com.epam.preprod.roman_lutsenko.util.UserExtractor.phoneNumbers;
import static com.epam.preprod.roman_lutsenko.util.UserSessionSaver.clearSessionFromUserFields;
import static com.epam.preprod.roman_lutsenko.util.UserSessionSaver.setValidFieldsToSession;
import static com.epam.preprod.roman_lutsenko.util.UserValidation.validateFields;

/**
 * Process registration form and check if user with this phone consist in User container.
 */
@WebServlet("/registration")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {
    private final Logger LOG = Logger.getLogger(RegistrationServlet.class);

    //todo: need to be refactored
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.debug(getClass() + Messages.STARTED);
        Context context = (Context) req.getServletContext().getAttribute(SESSION_CONTEXT);
        User user = UserExtractor.extractUserFromRequest(req);
        user = isValidUser(req, user);
        if (isValidCaptcha(req, context)) {
            if (Objects.isNull(user)) {
                req.getSession().setAttribute(SESSION_ERR_MESS, REGISTRATION_NON_VALID_FIELDS);
                resp.sendRedirect(REGISTRATION_SERVLET);
            } else {
                try {
                    context.getUserService().add(user);
                    LOG.debug("added");
                    getAvatar(req, user);
                    resp.sendRedirect(INDEX_JSP);
                } catch (UserDuplicateException e) {
                    LOG.debug("UserDupl ", e);
                    req.getSession().setAttribute(SESSION_ERR_MESS, ERR_USER_WITH_SUCH_PHONE_REGISTERED);
                    resp.sendRedirect(REGISTRATION_SERVLET);
                }
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

    /**
     * @return User instance with setted fields or <b>null</b> if user cannot insert to user container.
     */
    private User isValidUser(HttpServletRequest request, User user) {
        Set set = validateFields(user);
        if (set.isEmpty()) {
            clearSessionFromUserFields(request);
            return user;
        }
        setValidFieldsToSession(request, user);
        return null;
    }

    private void getAvatar(HttpServletRequest req, User user) {
        final String filePath = SAVE_AVATAR_PATH + phoneNumbers(user.getPhone()) + ".jpg";

        if (isAvatarUploaded(req)) {
            try (OutputStream out = new FileOutputStream(filePath);
                 InputStream fileContent = req.getPart(FORM_REGISTERED_AVATAR).getInputStream()) {
                int read;
                final byte[] bytes = new byte[1024];

                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            } catch (Exception e) {
                LOG.warn(FORM_REGISTERED_AVATAR, e);
            }
        }
    }

    private boolean isAvatarUploaded(HttpServletRequest req) {
        try {
            if (req.getPart(FORM_REGISTERED_AVATAR).getSize() == 0) {
                return false;
            }
        } catch (IOException | ServletException e) {
            LOG.warn(FORM_REGISTERED_AVATAR, e);
        }
        return true;
    }
}
