package com.order.game.character.playable;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.order.game.character.Character;
import com.order.game.map.CoordinatesHelper;

public class Player extends Character {


    public Player (Vector3 spawnPoint) {
        this.position = CoordinatesHelper.V2toV3(CoordinatesHelper.getTileCenter(spawnPoint));
        this.speed = 6;
        this.name = "Player";
    }


}
