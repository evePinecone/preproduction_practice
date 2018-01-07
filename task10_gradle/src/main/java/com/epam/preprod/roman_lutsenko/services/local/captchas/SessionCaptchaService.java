package com.epam.preprod.roman_lutsenko.services.local.captchas;

import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.util.GenerateCaptcha;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Captcha that saved its id in session attributes.
 */

public class SessionCaptchaService extends AbstractCaptchaService {

    private static final Logger logger = Logger.getLogger(SessionCaptchaService.class);

    public SessionCaptchaService() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        String uuid = (String) request.getSession().getAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA);
        cleanInvalidCaptcha(map);
        return map.get(uuid);
    }

    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        map.put(captcha.getUuid(), captcha);
        request.getSession().setAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid());
        logger.debug(getClass() + Messages.INITIALIZED);
    }
}
