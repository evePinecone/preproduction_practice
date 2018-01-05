package com.epam.preprod.roman_lutsenko.web.tags;


import com.epam.preprod.roman_lutsenko.constants.FieldsName;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CaptchaTag extends TagSupport {

    private final static Logger logger = Logger.getLogger(CaptchaTag.class);
//todo: captcha is not writed.
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<ul class=\"actions\">\n");
            String id_captcha = null;
            id_captcha = (String)pageContext.getSession().getAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA);

            out.print("<li id=\"captcha_confirm\" class=\"captchas\">\n" +
                    "<img src=\"captchas\" id=\"id_captcha\" value=\"" + id_captcha + "\"/>\n" +
                    "</li>\n" +
                    "<li class=\"form__item captchas\">\n" +
                    "<input id=\"captcha_value\" name=\"captcha_value\" type=\"text\" placeholder=\"Captcha\"/>\n" +
                    "<div class=\"invalid_input\">Invalid captchas</div>\n" +
                    "</li>\n" +
                    "</ul>");
            id_captcha = (String)pageContext.getServletContext().getAttribute(FieldsName.TAG_CAPTCHA_ID_CAPTCHA);
            out.print("<input type=\"hidden\" id=\"hidden\" name=\"hidden\" value=\"" + id_captcha + "\"/>");
            out.flush();

        } catch (IOException e) {
            logger.error(getClass() + e.toString());
        }
        return SKIP_BODY;
    }
}
