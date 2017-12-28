package com.epam.preprod.roman_lutsenko.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class ShopContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("___________________________________________________");
        System.out.println("com.epam.preprod.roman_lutsenko.web.listeners.ShopContextListener contextInitialized");

//        //String string = servletContextEvent.getServletContext().getInitParameter("captchaMethod");
//        ServletContext servletContext = servletContextEvent.getServletContext();
//
//        String userDaoClassName = (String)servletContext.getAttribute("UserDao");
//        String userServiceClassName = (String)servletContext.getAttribute("UserService");
//        UserDao userDAO;
//        UserService userService = null;
//        try {
//            Class userDaoClass = Class.forName(userDaoClassName);
//            userDAO = (UserDao) userDaoClass.newInstance();
//            Class userServiceClass = Class.forName(userServiceClassName);
//            Constructor constructor = userServiceClass.getDeclaredConstructor(userDaoClass);
//            userService = (UserService) constructor.newInstance(userDAO);
//           // userService = (UserService) userServiceClass.newInstance(userDAO);
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        Context context = new Context(userService);
//
//        servletContext.setAttribute("context", context);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("___________________________________________________");
        System.out.println("com.epam.preprod.roman_lutsenko.web.listeners.ShopContextListener destroyed");
    }
}
