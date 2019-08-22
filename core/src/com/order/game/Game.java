package com.order.game;

import com.order.game.screens.GameScreen;

public class Game extends com.badlogic.gdx.Game {

	//Config Values
	public final static int WIDTH = 1280;
	public final static int HEIGHT = 720;
	public final static int TILE_WIDTH = 128;
	public final static int TILE_HEIGHT = 64;
	
	@Override
	public void create () {
		this.setScreen(new GameScreen(this));
	}

	
	@Override
	public void dispose () {

	}
}
