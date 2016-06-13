package com.mysokoban.quer.controller;

import com.mysokoban.quer.model.Direction;

/**
 * Created by Qouer on 18.05.2016.
 */
public interface EventListener {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}
