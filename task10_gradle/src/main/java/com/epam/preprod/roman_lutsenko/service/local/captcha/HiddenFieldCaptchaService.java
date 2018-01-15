package com.epam.preprod.roman_lutsenko.service.local.captcha;

import com.epam.preprod.roman_lutsenko.entity.Captcha;
import com.epam.preprod.roman_lutsenko.util.GenerateCaptcha;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

import static com.epam.preprod.roman_lutsenko.constant.Fields.TAG_CAPTCHA_ID_CAPTCHA;

/**
 * Captcha that saved its id in hidden field on form.
 */
public class HiddenFieldCaptchaService extends AbstractCaptchaService {

    private static final Logger logger = Logger.getLogger(SessionCaptchaService.class);

    public HiddenFieldCaptchaService() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        String captchaId = (String) request.getServletContext().getAttribute(TAG_CAPTCHA_ID_CAPTCHA);
        logger.debug(getClass() + " captchaId " + captchaId);
        cleanInvalidCaptcha();
        return map.get(captchaId);
    }

    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        request.getServletContext().setAttribute(TAG_CAPTCHA_ID_CAPTCHA, captcha.getUuid());
        map.put(captcha.getUuid(), captcha);
        logger.debug(" addCaptcha " + captcha.getUuid() + " getById attr = " + request.getServletContext().getAttribute(TAG_CAPTCHA_ID_CAPTCHA));
    }
}
