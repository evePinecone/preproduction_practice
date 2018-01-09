package com.epam.preprod.roman_lutsenko.service;

import com.epam.preprod.roman_lutsenko.entity.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface of captcha setting.
 */
public interface CaptchaService {

    /**
     * Return captcha from the map by with specified type setting.
     * @param request request from client or jsp.
     * @return captcha instance from map with unique UUID.
     */
    Captcha getCaptcha(HttpServletRequest request);

    /**
     * Check if capture value coincides with true value.
     * @param request request from the client or jsp.
     * @param captureValue value setted from the form field.
     * @return <b>true</b> if value on this id is equal.
     */
    boolean isCorrectCaptcha(HttpServletRequest request, String captureValue);

    /**
     * Generate captcha and set specified identificator with choose realisation.
     * @param request request from the client or jsp.
     * @param response responce for client or jsp.
     */
    void addCaptcha(HttpServletRequest request, HttpServletResponse response);
}
