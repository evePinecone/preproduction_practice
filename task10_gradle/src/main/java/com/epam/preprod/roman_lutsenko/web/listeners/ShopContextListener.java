package com.epam.preprod.roman_lutsenko.web.listeners;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.dao.localImpl.LocalUserDao;
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
        Context context = new Context(new LocalUserService(new LocalUserDao()));
        servletContext.setAttribute("context", context);
        logger.debug(getClass() + Messages.INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug(getClass() + Messages.DESTROYED);
    }
}
