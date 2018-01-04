package com.epam.preprod.roman_lutsenko.services;

import com.epam.preprod.roman_lutsenko.entities.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaService {

    Captcha getCaptcha(HttpServletRequest request);

    boolean isCorrectCaptcha(HttpServletRequest request, String captureValue);

    void addCaptcha(HttpServletRequest request, HttpServletResponse response);
}
