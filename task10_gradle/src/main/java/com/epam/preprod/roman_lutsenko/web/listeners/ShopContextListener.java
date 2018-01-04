package com.epam.preprod.roman_lutsenko.web.listeners;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.dao.localImpl.LocalUserDao;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.services.localImpl.ContextCaptchaService;
import com.epam.preprod.roman_lutsenko.services.localImpl.LocalUserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ShopContextListener implements ServletContextListener{
    private final Logger logger = Logger.getLogger(ShopContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        UserDao userDao = new LocalUserDao();

        UserService userService = new LocalUserService(userDao);
        CaptchaService captchaService = new ContextCaptchaService();

        Context context = new Context(userService, captchaService);
        servletContext.setAttribute("context", context);
        logger.debug(getClass() + Messages.INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug(getClass() + Messages.DESTROYED);
    }
}
