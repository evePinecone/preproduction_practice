package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.entities.Captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.UUID;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

/**
 * Util class that generates captcha.
 */

public class GenerateCaptcha {

    private static final int WIDTH = 150;
    private static final int HEIGHT = 50;
    private static final int SIZE_CHARACTER = 18;
    private static final int SIZE_CAPTCHA = 2;
    private static final Font FONT = new Font("Georgia", Font.BOLD, SIZE_CHARACTER);

    private GenerateCaptcha(){
        throw new UnsupportedOperationException();
    }


    public static Captcha generateCaptcha() {

        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();


        g2d.setFont(FONT);

        RenderingHints renderingHints = new RenderingHints(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(renderingHints);

        GradientPaint gp = new GradientPaint(0, 0,
                Color.red, 0, HEIGHT / 2, Color.black, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        g2d.setColor(new Color(255, 153, 0));

        Random r = new Random();
        int index = Math.abs(r.nextInt()) % 5;

        UUID uuid = UUID.randomUUID();
        char[] chars = uuid.toString().substring(0, SIZE_CAPTCHA).toCharArray();
        String captchaValue = String.copyValueOf(chars);

        int x = 0;
        int y = 0;

        for (int i = 0; i < SIZE_CAPTCHA; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(chars, i, 1, x, y);
        }

        g2d.dispose();
        return new Captcha(captchaValue, bufferedImage);
    }
}
