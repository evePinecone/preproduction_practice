package com.epam.preprod.roman_lutsenko.web.listeners;

import com.epam.preprod.roman_lutsenko.constants.factories.CaptchaServiceFactory;
import com.epam.preprod.roman_lutsenko.constants.factories.DBServiceFactory;
import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.constants.CaptchaServiceProvider;
import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.dao.local.LocalUserDao;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.TestService;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.services.local.LocalUserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;


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

        UserDao userDao = new LocalUserDao(fill());

        UserService userService = new LocalUserService(userDao);
        logger.debug("captureService = " + captchaServiceString);
        CaptchaService captchaService = (new CaptchaServiceProvider()).getCaptchaService(captchaServiceString);
        logger.debug("captureServiceClass = " + captchaService.getClass().getSimpleName());

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


    /**
     * Cheating method with constant users.
     */
    private Map<String, User> fill() {
        Map<String, User> map = new HashMap<>();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setId(1);
        user1.setName("name" + 1);
        user1.setEmail("email" + 1);
        user1.setPhone("38000000000" + 1);
        user1.setPassword("password" + 1);

        user2.setId(2);
        user2.setName("name" + 2);
        user2.setEmail("email" + 2);
        user2.setPhone("38000000000" + 2);
        user3.setPassword("password" + 2);

        user1.setId(3);
        user1.setName("name" + 3);
        user1.setEmail("email" + 3);
        user1.setPhone("38000000000" + 3);
        user1.setPassword("password" + 3);

        map.put(user1.getPhone(), user1);
        map.put(user2.getPhone(), user2);
        map.put(user3.getPhone(), user3);
        return map;
    }
}
