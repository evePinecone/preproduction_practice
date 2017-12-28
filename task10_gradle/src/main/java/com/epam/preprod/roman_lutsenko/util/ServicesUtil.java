package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.dao.localImpl.LocalUserDao;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.services.localImpl.LocalUserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@WebListener
public class ServicesUtil implements ServletContextListener{
    final static Logger logger = Logger.getLogger(Context.class);

    //set some attr
    private static String userServiceName;
    private static String userDaoName;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        userServiceName = servletContext.getInitParameter("UserDao");
        userDaoName = servletContext.getInitParameter("UserService");
        logger.debug(getClass() + Messages.INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug(getClass() + Messages.DESTROYED);
    }

    public UserService getUserService() {
        logger.debug("start getUserService");
        logger.debug("userDaoName = " + userDaoName );
        UserService userService = null;
        try {
            Class userDaoClass = Class.forName(userDaoName);
            logger.debug("setting user class dao " + userDaoClass);
            // Саш, а как вот тут сделать инстанс класса, название которого взято с параметров web.xml?
            UserDao userDao = (LocalUserDao) userDaoClass.newInstance();
            logger.debug("instance user class dao " + userDaoClass);
            Class userServiceClass = Class.forName(userServiceName);
            logger.debug("setting user service " + userServiceClass);
            Constructor constructor = userServiceClass.getDeclaredConstructor(userDaoClass);
            userService = (UserService) constructor.newInstance(userDao);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //return userService;
        return new LocalUserService(new LocalUserDao());
    }
}
