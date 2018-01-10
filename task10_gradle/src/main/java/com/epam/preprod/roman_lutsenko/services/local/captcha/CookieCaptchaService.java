package com.epam.preprod.roman_lutsenko.services.local.captcha;

import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.util.GenerateCaptcha;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Captcha that saved its id in clients cookies.
 */
public class CookieCaptchaService extends AbstractCaptchaService {

    private static final Logger logger = Logger.getLogger(CookieCaptchaService.class);


    public CookieCaptchaService() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        cleanInvalidCaptcha();
        return getCaptchaFrom(cookies);
    }


    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        map.put(captcha.getUuid(), captcha);
        Cookie cookie = new Cookie(FieldsName.TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid());
        response.addCookie(cookie);
        logger.debug("put cookie " + cookie);
    }

    private Captcha getCaptchaFrom(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(FieldsName.TAG_CAPTCHA_ID_CAPTCHA)) {
                return map.get(cookie.getValue());
            }
        }
        return null;
    }
}
