package com.epam.preprod.roman_lutsenko.web.servlets;

import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static com.epam.preprod.roman_lutsenko.constants.FieldsName.TAG_CAPTCHA_TIMEOUT;

/**
 * Drawing captchas with specified service method.
 */
@WebServlet("/captchas")
public class CaptchaServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(CaptchaServlet.class);

    private ServletContext servletContext;
    private Context context;

    // context to const
    public CaptchaServlet() {
        this.servletContext = this.getServletContext();
        this.context = (Context) servletContext.getAttribute(FieldsName.SESSION_CONTEXT);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {
        logger.debug(getServletName() + Messages.GET_METHOD_START);
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();

        CaptchaService captchaService = context.getCaptchaService();

        Captcha captcha = captchaService.getCaptcha(request);

        Timer timer = new Timer(true);
        int minutes = Integer.parseInt(servletContext.getInitParameter(TAG_CAPTCHA_TIMEOUT));
        timer.schedule(new ScheduleTask(captcha), TimeUnit.MINUTES.toMillis(minutes));

        ImageIO.write(captcha.getBufferedImage(), "png", os);
        logger.debug(getServletName() + Messages.GET_METHOD_ENDED);
    }

    private class ScheduleTask extends TimerTask {
        private Captcha captcha;

        ScheduleTask(Captcha captcha) {
            this.captcha = captcha;
        }

        @Override
        public void run() {
            captcha.cleanValue();
        }
    }
}

