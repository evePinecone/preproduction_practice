package com.epam.preprod.roman_lutsenko.web.tags;


import com.epam.preprod.roman_lutsenko.context.Context;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.StringWriter;



public class CaptchaTag extends TagSupport {

    private final static Logger logger = Logger.getLogger(CaptchaTag.class);

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Context context = (Context) pageContext.getAttribute("context");
        //TODO: CREATE CAPTURE SERVICE!!! in capture service create map container with captcha.
        try {
            out.print("<img src='captcha' id='" + 123+ "'/>");
        } catch (IOException e) {
            logger.error(getClass() + e.toString());
        }
        return SKIP_BODY;
    }

    //do start Tag
    //get Servlet context need!!!! to reach value


}
