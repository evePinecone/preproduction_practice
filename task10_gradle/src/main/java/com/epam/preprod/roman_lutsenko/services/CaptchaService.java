package com.epam.preprod.roman_lutsenko.services;

import com.epam.preprod.roman_lutsenko.entities.Captcha;

import java.util.UUID;

public interface CaptchaService {
    Captcha getCaptcha(UUID idCaptcha);

    boolean isCorrectCaptcha(UUID idCaptcha, String captchaValue);

    Captcha addCaptcha();
}
