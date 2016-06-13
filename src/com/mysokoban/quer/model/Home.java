package com.mysokoban.quer.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Qouer on 18.05.2016.
 */
public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setWidth(5);
        setHeight(5);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int centerX = getX() - getWidth() / 2;
        int centerY = getY() - getHeight() / 2;

        graphics.drawRect(centerX, centerY, getWidth(), getHeight());
        graphics.fillRect(centerX, centerY, getWidth(), getHeight());
    }
}
