package com.epam.preprod.roman_lutsenko.services.local.captcha;

import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractCaptchaService implements CaptchaService {

    private static final String EMPTY_STRING = "";
    Map<String, Captcha> map;

    @Override
    public boolean isCorrectCaptcha(HttpServletRequest request, String captchaValue) {
        Captcha captchaBase = getCaptcha(request);
        return (Objects.nonNull(captchaBase) && captchaBase.getValue().equals(captchaValue));
    }

    void cleanInvalidCaptcha() {

        map.forEach((key, value) -> {
            if (Objects.equals(value.getValue(), EMPTY_STRING)) {
                map.remove(key);
            }
        });
    }
}
