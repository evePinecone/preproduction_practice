package com.epam.preprod.roman_lutsenko.web.tags;


import com.epam.preprod.roman_lutsenko.context.Context;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.UUID;


public class CaptchaTag extends TagSupport {

    private final static Logger logger = Logger.getLogger(CaptchaTag.class);

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Context context = (Context) pageContext.getAttribute("context");
        //TODO: CREATE CAPTURE SERVICE!!! in capture service create map container with captcha. no captcha in session
        try {
            logger.debug("TAG SESSION UUID = " + pageContext.getSession().getAttribute("id_captcha"));
            out.print("<ul class=\"actions\">\n" );

            UUID id_captcha = (UUID)pageContext.getSession().getAttribute("id_captcha");
            out.print("<li id=\"captcha_confirm\" class=\"captcha\">\n" +
                    "<img src=\"captcha\" id=\"id_captcha\" value=\""+ id_captcha +"\"/>\n" +
                    "</li>\n" +
                    "<li class=\"form__item captcha\">\n" +
                    "<input id=\"captcha_value\" name=\"captcha_value\" type=\"text\" placeholder=\"Captcha\"/>\n" +
                    "<div class=\"invalid_input\">Invalid captcha</div>\n" +
                    "</li>\n" +
                    "</ul>");
        } catch (IOException e) {
            logger.error(getClass() + e.toString());
        }
        return SKIP_BODY;
    }
}
