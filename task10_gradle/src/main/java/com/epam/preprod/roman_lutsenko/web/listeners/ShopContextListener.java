package com.epam.preprod.roman_lutsenko.web.listeners;

import com.epam.preprod.roman_lutsenko.constants.CaptchaServiceFactory;
import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.dao.localImpl.LocalUserDao;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.services.localImpl.LocalUserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Initiates context of the program with services with parameters from the configuration files.
 */
@WebListener
public class ShopContextListener implements ServletContextListener {
    private final Logger logger = Logger.getLogger(ShopContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug(getClass() + Messages.INITIALIZED);
        ServletContext servletContext = servletContextEvent.getServletContext();

        String captchaServiceString = servletContext.getInitParameter(FieldsName.INIT_LISTENER_CAPTCHA);

        UserDao userDao = new LocalUserDao();

        UserService userService = new LocalUserService(userDao);
        logger.debug("captureService = " + captchaServiceString);
        CaptchaService captchaService = (new CaptchaServiceFactory()).getCaptchaService(captchaServiceString);
        logger.debug("captureServiceClass = " + captchaService.getClass());

        Context context = new Context(userService, captchaService);
        servletContext.setAttribute(FieldsName.SESSION_CONTEXT, context);
        logger.debug(getClass() + Messages.INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug(getClass() + Messages.DESTROYED);
    }
}
