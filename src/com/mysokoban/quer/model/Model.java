package com.mysokoban.quer.model;

import com.mysokoban.quer.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

/**
 * Created by Qouer on 17.05.2016.
 */
public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader
            = new LevelLoader(Paths.get("./levels/levels.txt"));
    public static int FIELD_SELL_SIZE = 40;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = getGameObjects().getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)) {
            return;
        }

        switch (direction) {
            case LEFT:
                player.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_SELL_SIZE);
                break;
        }

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : getGameObjects().getWalls()) {
            if (gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {
        Player player = gameObjects.getPlayer();

        GameObject stopItem = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stopItem = gameObject;
            }
        }

        if ((stopItem == null)){
            return false;
        }

        if (stopItem instanceof Box){
            Box stopItemBox = (Box) stopItem;

            if (checkWallCollision(stopItemBox, direction)) {
                return true;
            }

            Set<Box> boxes = gameObjects.getBoxes();
            for (Box box : boxes) {
                if (stopItemBox.isCollision(box, direction)) {
                    return true;
                }
            }

            switch (direction)
            {
                case LEFT:
                    stopItemBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopItemBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopItemBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopItemBox.move(0, FIELD_SELL_SIZE);
            }
        }

        return false;

    }

    public void checkCompletion() {
        Set<Home> homes = gameObjects.getHomes();
        Set<Box> boxes = gameObjects.getBoxes();

        boolean globalIsEqual = true;

        for(Home home : homes){
            boolean localIsEqual = false;

            for (Box box: boxes){
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    localIsEqual = true;
            }

            if (!localIsEqual) {
                globalIsEqual = false;
            }

        }

        if (globalIsEqual) {
            eventListener.levelCompleted(currentLevel);
        }
    }


}
