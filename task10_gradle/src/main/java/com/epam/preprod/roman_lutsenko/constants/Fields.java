package com.epam.preprod.roman_lutsenko.constants;

/**
 * Fields from requests and configuration.
 */
public class Fields {

    //registration.jsp
    public static final String FORM_REGISTRATION_NAME = "name";
    public static final String FORM_REGISTRATION_EMAIL = "email";
    public static final String FORM_REGISTRATION_PHONE = "phone";
    public static final String FORM_REGISTRATION_PASSWORD = "password";

    //error.jsp
    public static final String ERR_DBEXCEPTION = "message";
    public static final String EXCEPTION_ATTR_IN_SESSION = "javax.servlet.error.exception";

    //tag captcha
    public static final String TAG_CAPTCHA_INPUT_VALUE = "captcha_value";
    public static final String TAG_CAPTCHA_ID_CAPTCHA = "id_captcha";

    //Session attributes
    public static final String SESSION_CONTEXT = "context";
    public static final String SESSION_ERR_MESS = "err_mess";


    //LISTENER
    //captcha
    public static final String INIT_LISTENER_CAPTCHA = "Captcha";
    public static final String INIT_LISTENER_CONTEXT_CLASS = "com.epam.preprod.roman_lutsenko.services.local.ContextCaptchaService";
    public static final String INIT_LISTENER_COOKIE_CLASS = "com.epam.preprod.roman_lutsenko.services.local.CookieCaptchaService";
    public static final String INIT_LISTENER_HIDDEN_FIELD_CLASS = "com.epam.preprod.roman_lutsenko.services.local.HiddenFieldCaptchaService";

    //database
    public static final String INIT_LISTENER_DBFACTORY = "DataBaseClassFactory";
    public static final String INIT_LISTENER_MYSQL = "MySqlServiceFactory";


    //base entity
    public static final String ID = "id";

    //test table
    public static final String TEST_QWEQWE = "qweqwe";
    public static final String TEST_TEXT = "text";

    //jsp pages
    public static final String JSP_ERROR = "error.jsp";
}
