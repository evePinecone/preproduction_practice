package com.epam.preprod.roman_lutsenko.services.local.captchas;

import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.util.GenerateCaptcha;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;

/**
 * Captcha that saved its id in hidden field on form.
 */
public class HiddenFieldCaptchaService extends AbstractCaptchaService{

    private static final Logger logger = Logger.getLogger(ContextCaptchaService.class);

    public HiddenFieldCaptchaService() {
        map = Collections.synchronizedMap(new HashMap<>());
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        String captchaId = (String)request.getServletContext().getAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA);
        logger.debug(getClass() + " captchaId " + captchaId);
        cleanInvalidCaptcha(map);
        return map.get(captchaId);
    }

    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        request.getServletContext().setAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid());
        map.put(captcha.getUuid(), captcha);
        logger.debug(" addCaptcha " + captcha.getUuid() + " get attr = " + request.getServletContext().getAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA));
    }
}