package com.epam.preprod.roman_lutsenko.services.localImpl;

import com.epam.preprod.roman_lutsenko.services.CaptchaService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ContextCaptchaService implements CaptchaService{

    private Map<Integer, String> map;

    public ContextCaptchaService() {
        map = new HashMap<>();
    }

    @Override
    public String getCaptcha(Integer idCaptcha) {
        return map.get(idCaptcha);
    }

    @Override
    public boolean isCorrectCaptcha(Integer idCaptcha, String captcha) {
        String captchaBase = map.get(idCaptcha);
        return (Objects.nonNull(captchaBase) && captchaBase.equals(captcha));
    }

    @Override
    public void addCaptcha(Integer idCaptcha, String captcha) {
        map.put(idCaptcha, captcha);
    }
}
