package com.epam.preprod.roman_lutsenko.web.listener;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.constant.provider.CaptchaServiceProvider;
import com.epam.preprod.roman_lutsenko.constant.provider.DBServiceProvider;
import com.epam.preprod.roman_lutsenko.context.Context;
import com.epam.preprod.roman_lutsenko.db.util.TransactionManager;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.service.CaptchaService;
import com.epam.preprod.roman_lutsenko.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.constant.Messages.CAPTCHA_SERVICE_CLASS;


/**
 * Initiates context of the program with service with parameters from the configuration files.
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

        CaptchaService captchaService = (new CaptchaServiceProvider()).getCaptchaService(captchaServiceString);
        logger.debug(CAPTCHA_SERVICE_CLASS + captchaService.getClass().getSimpleName());

        TransactionManager transactionManager = new TransactionManager();
        DBServiceProvider dbServiceProvider = new DBServiceProvider(transactionManager);
        dbServiceProvider.setServiceFactoryName(dbChoice);
        UserService userService = dbServiceProvider.getInstance().getUserService();

        Context context = new Context(userService, captchaService);
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
