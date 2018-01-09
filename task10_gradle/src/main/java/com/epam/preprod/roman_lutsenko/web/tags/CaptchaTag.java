package com.epam.preprod.roman_lutsenko.web.tags;


import com.epam.preprod.roman_lutsenko.constants.Messages;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static com.epam.preprod.roman_lutsenko.constants.FieldsName.TAG_CAPTCHA_ID_CAPTCHA;

public class CaptchaTag extends TagSupport {

    private final static Logger LOG = Logger.getLogger(CaptchaTag.class);
    @Override
    public int doStartTag() throws JspException {
        LOG.debug(Messages.INITIALIZED);
        JspWriter out = pageContext.getOut();
        try {
            out.print("<ul class=\"actions\">\n");
            String id_captcha = null;
            id_captcha = (String)pageContext.getSession().getAttribute(TAG_CAPTCHA_ID_CAPTCHA);
            LOG.debug(TAG_CAPTCHA_ID_CAPTCHA + " " + id_captcha );
            out.print("<li id=\"captcha_confirm\" class=\"captcha\">\n" +
                    "<img src=\"captcha\" id=\"id_captcha\" value=\"" + id_captcha + "\"/>\n" +
                    "</li>\n" +
                    "<li class=\"form__item captcha\">\n" +
                    "<input id=\"captcha_value\" name=\"captcha_value\" type=\"text\" placeholder=\"Captcha\"/>\n" +
                    "<div class=\"invalid_input\">Invalid captcha</div>\n" +
                    "</li>\n" +
                    "</ul>");
            id_captcha = (String)pageContext.getServletContext().getAttribute(TAG_CAPTCHA_ID_CAPTCHA);
            out.print("<input type=\"hidden\" id=\"hidden\" name=\"hidden\" value=\"" + id_captcha + "\"/>");
            out.flush();

        } catch (IOException e) {
            LOG.error(getClass() + e.toString());
        }
        LOG.debug(Messages.ENDED);
        return SKIP_BODY;
    }
}
