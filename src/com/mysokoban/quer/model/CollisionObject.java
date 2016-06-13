package com.mysokoban.quer.model;

/**
 * Created by Qouer on 17.05.2016.
 */
public abstract class CollisionObject extends GameObject{

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        boolean result = false;

        switch (direction) {
            case UP:
                if (getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY()) {
                    result = true;
                }
                break;
            case DOWN:
                if (getX() == gameObject.getX() && gameObject.getY() == getY() + Model.FIELD_SELL_SIZE) {
                    result = true;
                }
                break;
            case LEFT:
                if (getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) {
                    result = true;
                }
                break;
            case RIGHT:
                if (getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) {
                    result = true;
                }
                break;
        }

        return result;
    }
}
