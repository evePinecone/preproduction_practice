package com.epam.preprod.roman_lutsenko.services.local;

import com.epam.preprod.roman_lutsenko.constants.Fields;
import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import com.epam.preprod.roman_lutsenko.util.GenerateCaptcha;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Captcha that saved its id in session attributes.
 */
public class ContextCaptchaService implements CaptchaService {

    private static final Logger logger = Logger.getLogger(ContextCaptchaService.class);

    private Map<UUID, Captcha> map;

    public ContextCaptchaService() {
        map = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        UUID uuid = (UUID) request.getSession().getAttribute(Fields.TAG_CAPTCHA_ID_CAPTCHA);
        return map.get(uuid);
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
        request.getSession().setAttribute(Fields.TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid());
        logger.debug(getClass() + Messages.INITIALIZED);
    }
}
