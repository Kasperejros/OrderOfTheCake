package com.order.game.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class TileManager {

    public TiledMap map;
    private TiledMapTileLayer highlightLayer;
    private TiledMapTileLayer.Cell highlightedCell;
    private int previousCellX;
    private int previousCellY;

    public TileManager(TiledMap map) {
        this.map = map;
        highlightLayer =  (TiledMapTileLayer) map.getLayers().get(2);
        highlightedCell =  highlightLayer.getCell(0, 23);
        previousCellX = 0;
        previousCellY = 23;
    }


    public void highlightTile(int posX, int posY) {
        highlightLayer.setCell(posX,posY, highlightedCell);

        if(previousCellX != posX || previousCellY != posY) {
            highlightLayer.setCell(previousCellX, previousCellY, null);
        }
        previousCellX = posX;
        previousCellY = posY;
    }

}
