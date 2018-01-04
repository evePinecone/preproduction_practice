package com.epam.preprod.roman_lutsenko.services.localImpl;

import com.epam.preprod.roman_lutsenko.entities.Captcha;
import com.epam.preprod.roman_lutsenko.services.CaptchaService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class ContextCaptchaService implements CaptchaService {

    private static final Logger logger = Logger.getLogger(ContextCaptchaService.class);

    private Map<UUID, Captcha> map;

    public ContextCaptchaService() {
        map = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(UUID idCaptcha) {
        return map.get(idCaptcha);
    }

    @Override
    public boolean isCorrectCaptcha(UUID idCaptcha, String captchaValue) {
        showAllCaptcha();
        Captcha captchaBase = map.get(idCaptcha);
        return (Objects.nonNull(captchaBase) && captchaBase.getValue().equals(captchaValue));
    }

    @Override
    public Captcha addCaptcha() {
        Captcha captcha = null;
        try {
            captcha = generateCaptcha();
        } catch (ServletException | IOException e) {
            logger.error(getClass() + e.toString());
        }
        return captcha;
    }

    private void showAllCaptcha() {
        System.out.println(map);
    }

    private Captcha generateCaptcha()
            throws ServletException, IOException {
        logger.debug(getClass() + "ProcessRequest begin");
        int width = 150;
        int height = 50;

        char data[][] = {
                {'z', 'e', 't', 'c', 'o', 'd', 'e'},
                {'l', 'i', 'n', 'u', 'x'},
                {'f', 'r', 'e', 'e', 'b', 's', 'd'},
                {'u', 'b', 'u', 'n', 't', 'u'},
                {'j', 'e', 'e'}
        };


        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        GradientPaint gp = new GradientPaint(0, 0,
                Color.red, 0, height / 2, Color.black, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(255, 153, 0));

        Random r = new Random();
        int index = Math.abs(r.nextInt()) % 5;

        String captchaValue = String.copyValueOf(data[index]);

        int x = 0;
        int y = 0;

        for (int i = 0; i < data[index].length; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(data[index], i, 1, x, y);
        }

        g2d.dispose();

        Captcha captcha = new Captcha(captchaValue, bufferedImage);
        map.put(captcha.getUuid(), captcha);
        return captcha;
    }
}
