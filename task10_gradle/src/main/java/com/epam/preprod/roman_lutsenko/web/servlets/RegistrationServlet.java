package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.util.ParseInputData;
import com.epam.preprod.roman_lutsenko.util.ServicesUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug(getClass() + Messages.STARTED);
        if(containsUser((Integer) req.getAttribute("phone"))) {
            // cathc exception DuplicateUserException
            //resp.sendRedirect("/index.html");
        } else {
            // create validation.
        }
        logger.debug("context" + req.getServletContext().getAttribute("context"));
        logger.debug(getClass() + Messages.ENDED);
    }

    private User initUserFromForm(HttpServletRequest request) {
        User user = new User();
        user.setName((String)request.getAttribute("name"));
        Integer validPhone = ParseInputData.phoneFromString((String)request.getAttribute("phone"));
        user.setPhone(validPhone);
        user.setEmail((String)request.getAttribute("email"));
        user.setPassword((String)request.getAttribute("password"));
        return user;
    }

    private boolean containsUser(Integer phone) {
        ServicesUtil servicesUtil = new ServicesUtil();
        UserService userService = servicesUtil.getUserService();
        return userService.contains(phone);
    }
}
