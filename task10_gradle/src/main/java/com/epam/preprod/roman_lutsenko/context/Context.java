package com.epam.preprod.roman_lutsenko.context;

import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.TestService;
import com.epam.preprod.roman_lutsenko.services.UserService;

public class Context{

    private UserService userService;
    private CaptchaService captchaService;

    private TestService testService;

    public Context(UserService userService, CaptchaService captchaService, TestService testService) {
        this.userService = userService;
        this.captchaService = captchaService;
        this.testService = testService;
    }

//    public Context(UserService userService, CaptchaService captchaService) {
//        this.userService = userService;
//        this.captchaService = captchaService;
//    }

    public UserService getUserService() {
        return userService;
    }

    public CaptchaService getCaptchaService() {
        return captchaService;
    }

    public TestService getTestService() {
        return testService;
    }
}
