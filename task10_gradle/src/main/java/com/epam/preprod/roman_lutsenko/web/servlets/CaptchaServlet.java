package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(CaptchaServlet.class);


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug(getServletName() + Messages.GET_METHOD_START);
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();

        Context context = (Context) request.getServletContext().getAttribute(FieldsName.SESSION_CONTEXT);
        CaptchaService captchaService = context.getCaptchaService();
        logger.debug(captchaService.getCaptcha(request).getBufferedImage());
        ImageIO.write(captchaService.getCaptcha(request).getBufferedImage(), "png", os);
        logger.debug(getServletName() + Messages.GET_METHOD_ENDED);
    }

}

