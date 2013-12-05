package com.theepicgamer06.game.level.tile;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class TileGrassFlowers extends Tile {

	public TileGrassFlowers(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.RenderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){
		return true;
	}

}
