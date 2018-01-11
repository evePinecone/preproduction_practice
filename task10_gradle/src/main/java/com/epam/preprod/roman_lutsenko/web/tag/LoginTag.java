package com.epam.preprod.roman_lutsenko.web.tag;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constant.Fields.EMPTY_STRING;

public class LoginTag extends TagSupport {

    private static final Logger LOG = Logger.getLogger(LoginTag.class);


    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String errMess = (String) pageContext.getSession().getAttribute(Fields.SESSION_ERR_MESS);
            if (Objects.isNull(errMess)) {
                errMess = EMPTY_STRING;
            }

            out.print("<form class='login' action=\"login\" method=\"POST\">\n" +
                    "<div class=\"form__item\">" +
                    "        <input type=\"text\" id=\"phone\" name=\"phone\" placeholder=\"Phone\" />\n" +
                    "</div>" +
                    "<div class=\"form__item\">" +
                    "       <input id=\"password\" name=\"password\" placeholder=\"Password\" type=\"password\" />\n" +
                    "</div>" +
                    "        <ul class=\"actions\">\n" +
                    "                                <li><input id=\"submit\" type=\"submit\" class=\"special\" value=\"Submit\" /></li>\n" +
                    "                            </ul>" +
                    "        <div class=\"err_mess\">\n" +
                    "            " + errMess + "\n" +
                    "        </div>\n" +
                    "    </form>"
            );
        } catch (IOException e) {
            LOG.error(e);
        }
        return super.doStartTag();
    }
}
