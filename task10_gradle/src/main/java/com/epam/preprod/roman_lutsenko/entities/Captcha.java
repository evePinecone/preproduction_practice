package com.epam.preprod.roman_lutsenko.entities;

import java.awt.image.BufferedImage;
import java.util.UUID;

/**
 * Class container for Captcha entity.
 */
public class Captcha {

    private String uuid;
    private String value;
    private BufferedImage bufferedImage;

    public Captcha(String value, BufferedImage bufferedImage) {
        this.uuid =  UUID.randomUUID().toString();
        this.value = value;
        this.bufferedImage = bufferedImage;
    }

    public String getUuid() {
        return uuid;
    }

    public String getValue() {
        return value;
    }

    public void cleanValue() {
        this.value = "";
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
