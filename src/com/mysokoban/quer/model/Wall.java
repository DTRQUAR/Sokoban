package com.mysokoban.quer.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Qouer on 18.05.2016.
 */
public class Wall extends CollisionObject{

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.gray);
        int centerX = getX() - getWidth() / 2;
        int centerY = getY() - getHeight() / 2;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./resources/homeYellowPlitka.png"));
            graphics.drawImage(img, centerX, centerY, getWidth(), getHeight(), null);
        } catch (IOException e) {
        }
    }
}
