package com.order.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.order.game.Game;
import com.order.game.TurnManager;
import com.order.game.character.Character;
import com.order.game.character.npc.Enemy;
import com.order.game.character.playable.Player;
import com.order.game.map.CoordinatesHelper;
import com.order.game.map.Position;
import com.order.game.map.TileManager;

import java.util.ArrayList;

public class GameScreen extends AbstractScreen {

    private TiledMap tiledMap;
    private TileManager tileManager;
    private Player player;
    private Enemy enemy;
    private ArrayList<Character> characters;
    private Vector3 playerSpawn;
    private Vector3 enemySpawn;

    Position lastTappedTile = null;

    public GameScreen(Game g) {

        super(g);

        tiledMap = new TmxMapLoader().load("Maps/test_map.tmx");
        tileManager = new TileManager(tiledMap);
        tiledMapRenderer = new IsometricTiledMapRenderer(tileManager.map);

        playerSpawn = new Vector3(12,15,0);
        player = new Player (playerSpawn);

        enemySpawn = new Vector3(11, 6,0);
        enemy = new Enemy(enemySpawn);

        characters = new ArrayList<>();
        characters.add(player);
        characters.add(enemy);

        TurnManager.prepareQueue(characters);


        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

        super.render(delta);

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        for (Character c: characters
             ) {
            renderShape(c);
        }


    }

    // Shape rendering for characters in game.
    public void renderShape(Character c){
        if (c instanceof Player) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(1,1,0,1);
            shapeRenderer.rect(c.position.x -32 ,c.position.y ,64,64);
            shapeRenderer.end();
        } else {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(1,0,0,1);
            shapeRenderer.rect(c.position.x -32 ,c.position.y ,64,128);
            shapeRenderer.end();
        }
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        placeHighlight(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        placeHighlight(screenX, screenY);
        return false;
    }

    private Position placeHighlight(float x, float y){
        Vector3 position = new Vector3(x,y,0);
        position = camera.unproject(position);

        int cellX = (int) Math.floor(CoordinatesHelper.getTileCoordinates(position).x);
        int cellY = (int) Math.floor(CoordinatesHelper.getTileCoordinates(position).y);

        tileManager.highlightTile(cellX,cellY);
        lastTappedTile = new Position(cellX, cellY);
        return new Position(cellX, cellY);
    }
}
