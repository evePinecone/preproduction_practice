package com.epam.preprod.roman_lutsenko.entities;

import java.awt.image.BufferedImage;
import java.util.UUID;

public class Captcha {

    private UUID uuid;
    private String value;
    private BufferedImage bufferedImage;

    public Captcha(String value, BufferedImage bufferedImage) {
        this.uuid =  UUID.randomUUID();;
        this.value = value;
        this.bufferedImage = bufferedImage;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getValue() {
        return value;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    public String toString() {
        return "Captcha{" +
                "uuid=" + uuid +
                ", value='" + value + '\'' +
                ", bufferedImage=" + bufferedImage +
                '}';
    }
}
