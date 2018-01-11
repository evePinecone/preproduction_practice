package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.util.ValidateInput;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constant.Fields.EMPTY_STRING;
import static com.epam.preprod.roman_lutsenko.constant.Fields.FORM_REGISTRATION_PASSWORD;
import static com.epam.preprod.roman_lutsenko.constant.Fields.FORM_REGISTRATION_PHONE;
import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_CONTEXT;
import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_ERR_MESS;
import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_USER;

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
        req.getSession().removeAttribute(SESSION_ERR_MESS);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = extractLoginFromRequest(req);
        User userFromDB = context.getUserService().getById(user.getPhone());
        if(Objects.isNull(userFromDB) || !Objects.equals(userFromDB.getPassword(), user.getPassword())) {
            req.getSession().setAttribute(SESSION_ERR_MESS, "Incorrect data");
            resp.sendRedirect("login.jsp");
        } else {
            LOG.debug("user = " + userFromDB.getName());
            userFromDB.setPassword(EMPTY_STRING);
            req.getSession().setAttribute(SESSION_USER, userFromDB);
            resp.sendRedirect("catalog.jsp");
        }
        LOG.debug("IS IT WORKING?? ");
    }

    private static User extractLoginFromRequest(HttpServletRequest request) {
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
