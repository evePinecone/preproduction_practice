package com.epam.preprod.roman_lutsenko.constant.provider;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.service.CaptchaService;
import com.epam.preprod.roman_lutsenko.service.local.captcha.CookieCaptchaService;
import com.epam.preprod.roman_lutsenko.service.local.captcha.HiddenFieldCaptchaService;
import com.epam.preprod.roman_lutsenko.service.local.captcha.SessionCaptchaService;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Returns implementation of captcha service.
 */
public class CaptchaServiceProvider {

    private static final Logger logger = Logger.getLogger(CaptchaServiceProvider.class);

    private Map<String, CaptchaService> map = new HashMap<>();

    public CaptchaServiceProvider() {
        logger.debug(getClass() + Messages.INITIALIZED);
        map.put(Fields.INIT_LISTENER_CONTEXT_CLASS, new SessionCaptchaService());
        map.put(Fields.INIT_LISTENER_COOKIE_CLASS, new CookieCaptchaService());
        map.put(Fields.INIT_LISTENER_HIDDEN_FIELD_CLASS, new HiddenFieldCaptchaService());
    }

    public CaptchaService getCaptchaService(String className) {
        logger.debug(Messages.LOADED + className);
        return map.get(className);
    }
}
