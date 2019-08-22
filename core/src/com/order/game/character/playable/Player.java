package com.order.game.character.playable;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.order.game.character.Character;
import com.order.game.map.CoordinatesHelper;

public class Player extends Character {

    final String name = "Player";

    public Player (Vector3 position) {
        this.position = CoordinatesHelper.V2toV3(CoordinatesHelper.getTileCenter(position));
    }


}
