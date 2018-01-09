package com.epam.preprod.roman_lutsenko.web.listeners;

import com.epam.preprod.roman_lutsenko.constants.factories.CaptchaServiceFactory;
import com.epam.preprod.roman_lutsenko.constants.factories.DBServiceFactory;
import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.dao.local.LocalUserDao;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.TestService;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.services.local.LocalUserService;
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

        String captchaServiceString = servletContext.getInitParameter(Fields.INIT_LISTENER_CAPTCHA);
        String dbChoice = servletContext.getInitParameter(Fields.INIT_LISTENER_DBFACTORY);

        UserDao userDao = new LocalUserDao();

        UserService userService = new LocalUserService(userDao);
        logger.debug("captureService = " + captchaServiceString);
        CaptchaService captchaService = (new CaptchaServiceFactory()).getCaptchaService(captchaServiceString);
        logger.debug("captureServiceClass = " + captchaService.getClass());

        DBServiceFactory dbServiceFactory = new DBServiceFactory();
        dbServiceFactory.setServiceFactoryName(dbChoice);
        TestService testService = dbServiceFactory.getInstance().getTestService();

        Context context = new Context(userService, captchaService, testService);
        servletContext.setAttribute(Fields.SESSION_CONTEXT, context);
        logger.debug(getClass() + Messages.INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug(getClass() + Messages.DESTROYED);
    }
}
