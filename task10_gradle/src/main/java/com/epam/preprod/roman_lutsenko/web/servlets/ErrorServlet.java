package com.epam.preprod.roman_lutsenko.web.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.preprod.roman_lutsenko.constants.Fields.ERR_DBEXCEPTION;
import static com.epam.preprod.roman_lutsenko.constants.Fields.EXCEPTION_ATTR_IN_SESSION;
import static com.epam.preprod.roman_lutsenko.constants.Fields.JSP_ERROR;
import static com.epam.preprod.roman_lutsenko.constants.Messages.GET_METHOD_ENDED;
import static com.epam.preprod.roman_lutsenko.constants.Messages.GET_METHOD_START;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ErrorServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug(GET_METHOD_START);
        Throwable throwable = (Throwable)
                request.getAttribute(EXCEPTION_ATTR_IN_SESSION);
        request.setAttribute(ERR_DBEXCEPTION, throwable.getMessage());
        request.getRequestDispatcher(JSP_ERROR).forward(request, response);
        LOG.debug(GET_METHOD_ENDED);
    }
}
