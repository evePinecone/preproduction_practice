package com.epam.preprod.roman_lutsenko.constants;

/**
 * Fields from requests and configuration.
 */
public class FieldsName {

    //registration.jsp
    public static final String FORM_REGISTRATION_NAME = "name";
    public static final String FORM_REGISTRATION_EMAIL = "email";
    public static final String FORM_REGISTRATION_PHONE = "phone";
    public static final String FORM_REGISTRATION_PASSWORD = "password";

    //tag captchas
    public static final String TAG_CAPTCHA_INPUT_VALUE = "captcha_value";
    public static final String TAG_CAPTCHA_ID_CAPTCHA = "id_captcha";
    public static final String TAG_CAPTCHA_TIMEOUT = "captcha_timeout";


    //Session attributes
    public static final String SESSION_CONTEXT = "context";
    public static final String SESSION_ERR_MESS = "err_mess";


    //Listener
    public static final String INIT_LISTENER_CAPTCHA = "Captcha";
    public static final String INIT_LISTENER_CONTEXT_CLASS = "com.epam.preprod.roman_lutsenko.services.local.captchas.ContextCaptchaService";
    public static final String INIT_LISTENER_COOKIE_CLASS = "com.epam.preprod.roman_lutsenko.services.local.captchas.CookieCaptchaService";
    public static final String INIT_LISTENER_HIDDEN_FIELD_CLASS = "com.epam.preprod.roman_lutsenko.services.local.captchas.HiddenFieldCaptchaService";


}
