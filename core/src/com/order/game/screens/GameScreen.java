package com.order.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.order.game.Game;
import com.order.game.map.CoordinatesHelper;
import com.order.game.map.Position;
import com.order.game.map.TileManager;

public class GameScreen extends AbstractScreen {

    private TiledMap tiledMap;
    private TileManager tileManager;

    Position lastTappedTile = null;
    public GameScreen(Game g) {

        super(g);

        tiledMap = new TmxMapLoader().load("Maps/test_map.tmx");
        tileManager = new TileManager(tiledMap);
        tiledMapRenderer = new IsometricTiledMapRenderer(tileManager.map);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

        super.render(delta);

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
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
