package com.order.game.character.npc;

import com.badlogic.gdx.math.Vector3;
import com.order.game.character.Character;
import com.order.game.map.CoordinatesHelper;

public class Enemy extends Character {


    public Enemy (Vector3 spawnPoint) {
        this.position = CoordinatesHelper.V2toV3(CoordinatesHelper.getTileCenter(spawnPoint));
        this.speed = 10;
        this.name = "Enemy";
    }

}
