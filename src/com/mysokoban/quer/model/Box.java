package com.mysokoban.quer.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Qouer on 18.05.2016.
 */
public class Box extends CollisionObject implements Movable{

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int centerX = getX() - getWidth() / 2;
        int centerY = getY() - getHeight() / 2;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./resources/boxDollarBag.png"));
            graphics.drawImage(img, centerX, centerY, getWidth(), getHeight(), null);
        } catch (IOException e) {
        }

    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
