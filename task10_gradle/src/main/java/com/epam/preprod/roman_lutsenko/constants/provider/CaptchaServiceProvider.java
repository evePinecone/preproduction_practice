package com.epam.preprod.roman_lutsenko.constants.provider;

import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.local.captcha.CookieCaptchaService;
import com.epam.preprod.roman_lutsenko.services.local.captcha.HiddenFieldCaptchaService;
import com.epam.preprod.roman_lutsenko.services.local.captcha.SessionCaptchaService;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

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
