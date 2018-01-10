package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.util.ValidateInput;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constant.Fields.FORM_REGISTRATION_PASSWORD;
import static com.epam.preprod.roman_lutsenko.constant.Fields.FORM_REGISTRATION_PHONE;
import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_CONTEXT;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    //todo: login transaction create.
    private Context context;
    private static final Logger LOG = Logger.getLogger(LoginServlet.class);


    @Override
    public void init() throws ServletException {
        context = (Context) getServletContext().getAttribute(SESSION_CONTEXT);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = extractLoginFromRequest(req);
        try {
            context.getUserService().add(user);
            context.getUserService().getById(user.getPhone());
        } catch (UserDuplicateException e) {
            LOG.error("User with such phone registered, sorry");
        }
        req.getSession().setAttribute("User", user);
        LOG.debug("IS IT WORKING?? ");
    }

    public static User extractLoginFromRequest(HttpServletRequest request) {
        User user = new User();
        String field = (String) request.getParameter(FORM_REGISTRATION_PHONE);
        if (Objects.nonNull(field) && ValidateInput.validPhone(field)) {
            user.setPhone(field);
        }
        field = (String) request.getParameter(FORM_REGISTRATION_PASSWORD);
        if (Objects.nonNull(field) && ValidateInput.validPassword(field)) {
            user.setPassword(field);
        }
        return user;
    }
}
