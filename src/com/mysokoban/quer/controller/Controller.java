package com.mysokoban.quer.controller;

import com.mysokoban.quer.model.Direction;
import com.mysokoban.quer.model.GameObjects;
import com.mysokoban.quer.model.Model;
import com.mysokoban.quer.view.View;

/**
 * Created by Qouer on 17.05.2016.
 */
public class Controller implements EventListener{
    View view;
    Model model;

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    public Controller() {
        model = new Model();
        model.restart();
        model.setEventListener(this);
        view = new View(this);
        view.init();
        view.setEventListener(this);
    }

    @Override
    public void move(Direction direction) {
        this.model.move(direction);
        this.view.update();
    }

    @Override
    public void restart() {
        this.model.restart();
        this.view.update();
    }

    @Override
    public void startNextLevel() {
        this.model.startNextLevel();
        this.view.update();
    }

    public void startMyLevel(int level) {
        this.model.restartLevel(level);
        this.view.update();
    }

    @Override
    public void levelCompleted(int level) {
        this.view.completed(level);
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }
}
