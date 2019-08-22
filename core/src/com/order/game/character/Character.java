package com.order.game.character;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Character {

    private Sprite sprite;
    private Rectangle hitBox;
    public Vector3 position;

    public Character () { }

    private void update () { }
}
