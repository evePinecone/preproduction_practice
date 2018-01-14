package com.epam.preprod.roman_lutsenko.web.servlet;

import com.epam.preprod.roman_lutsenko.constant.Fields;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constant.Fields.SAVE_AVATAR_PATH;

@WebServlet("/avatar")
public class AvatarServlet extends HttpServlet{

    public static final Logger LOG = Logger.getLogger(AvatarServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filePath = (String) req.getSession().getAttribute(Fields.SESSION_AVATAR);;
        resp.setContentType("image/jpeg");
        try(ServletOutputStream out = resp.getOutputStream()) {
            if (Objects.isNull(filePath)) {
                filePath = SAVE_AVATAR_PATH + "default.jpg";
            }
            File file = new File(filePath);
            if (!file.exists()) {
                filePath = SAVE_AVATAR_PATH + "default.jpg";
            }
            LOG.debug("filePath " + filePath);
            try (FileInputStream fin = new FileInputStream(filePath);
                 BufferedInputStream bin = new BufferedInputStream(fin);
                 BufferedOutputStream bout = new BufferedOutputStream(out)) {
                int ch = 0;
                while ((ch = bin.read()) != -1) {
                    bout.write(ch);
                }
            }
        }
    }
}
