package com.order.game.character;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Character implements Comparable<Character>{

    private Sprite sprite;
    private Rectangle hitBox;
    public Vector3 position;
    public int speed;
    public String name;

    public Character () { }

    private void update () { }

    @Override
    public int compareTo(Character c) {

        int comparespeed = ((Character) c).speed;
        return this.speed - comparespeed;
    }
}
