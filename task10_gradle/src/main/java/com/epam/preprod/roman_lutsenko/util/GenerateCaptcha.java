package com.epam.preprod.roman_lutsenko.util;

import com.epam.preprod.roman_lutsenko.entities.Captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

/**
 * Util class that generates captha.
 */

//генерировать капчу с помощью UUID и обрезать
public class GenerateCaptcha {
    // дДобавить константу для длины капчи

    public static Captcha generateCaptcha() {
       // Move to const
        int width = 150;
        int height = 50;

        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        // Please, use const
        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);

        RenderingHints renderingHints = new RenderingHints(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(renderingHints);

        GradientPaint gp = new GradientPaint(0, 0,
                Color.red, 0, height / 2, Color.black, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(255, 153, 0));

        Random r = new Random();
        int index = Math.abs(r.nextInt()) % 5;

        //Please, use UUID
        char[] data = {'q','w','e'};
        String captchaValue = String.copyValueOf(data);

        int x = 0;
        int y = 0;

        for (int i = 0; i < 3; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(data, i, 1, x, y);
        }

        g2d.dispose();
        return new Captcha(captchaValue, bufferedImage);
    }
}
