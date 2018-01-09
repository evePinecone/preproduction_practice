package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

import static com.epam.preprod.roman_lutsenko.constants.Messages.GET_METHOD_ENDED;
import static com.epam.preprod.roman_lutsenko.constants.Messages.GET_METHOD_START;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

    private static final Logger LOG = Logger.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug(GET_METHOD_START);
        PrintWriter out = response.getWriter();
        try {
            Context context = (Context) this.getServletContext().getAttribute(Fields.SESSION_CONTEXT);
            context.getTestService().getSQLException();
        } catch (SQLException e) {
            //LOG.error(Messages.ERR_CANNOT_OBTAIN_TEST, e);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_TEST, e);
        }
//        Context context = (Context) request.getServletContext().getAttribute(Fields.SESSION_CONTEXT);
//        out.print(context.getTestService().getAllFields());
//        out.flush();
        LOG.debug(GET_METHOD_ENDED);
    }
}
