package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.entity.Captcha;
import com.epam.preprod.roman_lutsenko.service.CaptchaService;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static com.epam.preprod.roman_lutsenko.constant.Fields.SESSION_CONTEXT;
import static com.epam.preprod.roman_lutsenko.constant.Fields.TAG_CAPTCHA_TIMEOUT;


/**
 * Drawing captcha with specified service method.
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CaptchaServlet.class);

    private ServletContext servletContext;
    private Context context;

    @Override
    public void init() throws ServletException {
        LOG.debug(Messages.INITIALIZED);
        this.servletContext = this.getServletContext();
        this.context = (Context) servletContext.getAttribute(SESSION_CONTEXT);
        LOG.debug(SESSION_CONTEXT + " = " + context);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {
        LOG.debug(Messages.GET_METHOD_START);
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();

        CaptchaService captchaService = context.getCaptchaService();
        Captcha captcha = captchaService.getCaptcha(request);

        Timer timer = new Timer(true);
        int minutes = Integer.parseInt(servletContext.getInitParameter(TAG_CAPTCHA_TIMEOUT));
        timer.schedule(new ScheduleTask(captcha), TimeUnit.MINUTES.toMillis(minutes));

        ImageIO.write(captcha.getBufferedImage(), "png", os);
        LOG.debug(getServletName() + Messages.GET_METHOD_ENDED);
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

