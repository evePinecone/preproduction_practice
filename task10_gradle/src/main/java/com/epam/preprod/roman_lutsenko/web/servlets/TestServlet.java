package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.context.Context;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Context context = (Context) request.getServletContext().getAttribute(Fields.SESSION_CONTEXT);
        out.print(context.getTestService().getAllFields());
        out.flush();
    }
}
