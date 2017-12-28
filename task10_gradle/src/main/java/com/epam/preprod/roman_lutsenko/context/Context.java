package com.epam.preprod.roman_lutsenko.context;

import com.epam.preprod.roman_lutsenko.services.UserService;

public class Context{

    private UserService userService;

    public Context(UserService userService) {
        this.userService = userService;
        System.out.println("Context created");
    }

    public UserService getUserService() {
        return userService;
    }
}
