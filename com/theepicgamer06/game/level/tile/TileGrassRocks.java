package com.theepicgamer06.game.level.tile;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class TileGrassRocks extends Tile {

	public TileGrassRocks(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.RenderTile(x, y, TileGrass_rocks);
	}

}
