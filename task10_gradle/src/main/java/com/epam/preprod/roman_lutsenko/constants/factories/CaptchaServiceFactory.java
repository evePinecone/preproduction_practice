package com.epam.preprod.roman_lutsenko.constants.factories;

import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.services.local.ContextCaptchaService;
import com.epam.preprod.roman_lutsenko.services.local.CookieCaptchaService;
import com.epam.preprod.roman_lutsenko.services.local.HiddenFieldCaptchaService;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CaptchaServiceFactory {

    private static final Logger logger = Logger.getLogger(CaptchaServiceFactory.class);

    private Map<String, CaptchaService> map = new HashMap<>();

    public CaptchaServiceFactory() {
        logger.debug(getClass() + Messages.INITIALIZED);
        map.put(Fields.INIT_LISTENER_CONTEXT_CLASS, new ContextCaptchaService());
        map.put(Fields.INIT_LISTENER_COOKIE_CLASS, new CookieCaptchaService());
        map.put(Fields.INIT_LISTENER_HIDDEN_FIELD_CLASS, new HiddenFieldCaptchaService());
    }

    public CaptchaService getCaptchaService(String className) {
        logger.debug(Messages.LOADED + className);
        return map.get(className);
    }
}
