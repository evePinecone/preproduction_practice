package com.epam.preprod.roman_lutsenko.context;

import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.UserService;

public class Context{

    private UserService userService;
    private CaptchaService captchaService;

    public Context(UserService userService, CaptchaService captchaService) {
        this.userService = userService;
        this.captchaService = captchaService;
        System.out.println("Context created");
    }

    public UserService getUserService() {
        return userService;
    }

    public CaptchaService getCaptchaService() {
        return captchaService;
    }
}
