package com.epam.preprod.roman_lutsenko.services.localImpl;

import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.util.GenerateCaptcha;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class CookieCaptchaService implements CaptchaService {

    private static final Logger logger = Logger.getLogger(CookieCaptchaService.class);

    private Map<UUID, Captcha> map;

    public CookieCaptchaService() {
        map = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return getCaptchaFrom(cookies);
    }

    @Override
    public boolean isCorrectCaptcha(HttpServletRequest request, String captchaValue) {
        Captcha captchaBase = getCaptcha(request);
        return (Objects.nonNull(captchaBase) && captchaBase.getValue().equals(captchaValue));
    }

    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        map.put(captcha.getUuid(), captcha);
        Cookie cookie = new Cookie(FieldsName.TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid().toString());
        response.addCookie(cookie);
        logger.debug("put cookie " + cookie);
    }

    private Captcha getCaptchaFrom(Cookie[] cookies) {
        if (Objects.nonNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(FieldsName.TAG_CAPTCHA_ID_CAPTCHA)) {
                    logger.debug("cookie get from client " + map.get(UUID.fromString(cookie.getValue())));
                    return map.get(UUID.fromString(cookie.getValue()));
                }
            }
        }
        return null;
    }
}
