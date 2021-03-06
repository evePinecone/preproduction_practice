package com.epam.preprod.roman_lutsenko.context;

import com.epam.preprod.roman_lutsenko.service.CaptchaService;
import com.epam.preprod.roman_lutsenko.service.UserService;

public class Context{

    private UserService userService;
    private CaptchaService captchaService;

    public Context(UserService userService, CaptchaService captchaService) {
        this.userService = userService;
        this.captchaService = captchaService;
    }

    public UserService getUserService() {
        return userService;
    }

    public CaptchaService getCaptchaService() {
        return captchaService;
    }
}
