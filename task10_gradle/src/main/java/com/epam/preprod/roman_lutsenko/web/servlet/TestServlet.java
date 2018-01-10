package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.context.Context;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.epam.preprod.roman_lutsenko.constant.Messages.GET_METHOD_ENDED;
import static com.epam.preprod.roman_lutsenko.constant.Messages.GET_METHOD_START;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

    private static final Logger LOG = Logger.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug(GET_METHOD_START);
        PrintWriter out = response.getWriter();
//        try {
            Context context = (Context) this.getServletContext().getAttribute(Fields.SESSION_CONTEXT);
            //context.getTestService().getAllFields();
            out.print(context.getTestService().getAllFields());
//        } catch (SQLException e) {
//            throw new DBException(Messages.ERR_CANNOT_OBTAIN_TEST, e);
//        }
        LOG.debug(GET_METHOD_ENDED);
    }
}
