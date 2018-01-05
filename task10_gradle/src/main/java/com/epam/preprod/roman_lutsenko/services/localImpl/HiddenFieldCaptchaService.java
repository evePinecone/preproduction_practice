package com.epam.preprod.roman_lutsenko.services.localImpl;

import com.epam.preprod.roman_lutsenko.constants.Fields;
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
 * Captcha that saved its id in hidden field on form.
 */
public class HiddenFieldCaptchaService implements CaptchaService {

    private static final Logger logger = Logger.getLogger(ContextCaptchaService.class);

    private Map<UUID, Captcha> map;

    public HiddenFieldCaptchaService() {
        map = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        UUID captchaId = (UUID) request.getServletContext().getAttribute(Fields.TAG_CAPTCHA_ID_CAPTCHA);
        logger.debug(getClass() + " captchaId " + captchaId);
        return map.get(captchaId);
    }

    @Override
    public boolean isCorrectCaptcha(HttpServletRequest request, String captchaValue) {
        Captcha captchaBase = getCaptcha(request);
        return (Objects.nonNull(captchaBase) && captchaBase.getValue().equals(captchaValue));
    }

    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        request.getServletContext().setAttribute(Fields.TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid());
        map.put(captcha.getUuid(), captcha);
        logger.debug(" addCaptcha " + captcha.getUuid() + " get attr = " + request.getServletContext().getAttribute(Fields.TAG_CAPTCHA_ID_CAPTCHA));
    }
}
