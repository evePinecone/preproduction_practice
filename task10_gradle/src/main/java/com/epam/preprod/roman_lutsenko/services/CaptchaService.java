package com.epam.preprod.roman_lutsenko.services;

public interface CaptchaService {
    String getCaptcha(Integer idCaptcha);

    boolean isCorrectCaptcha(Integer idCaptcha, String captcha);

    void addCaptcha(Integer idCaptcha, String captcha);
}
