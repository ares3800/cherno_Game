package com.theepicgamer06.game.level.tile;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class TileGrassRocks extends Tile {

	public TileGrassRocks(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.RenderTile(x << 4, y << 4, this);
	}

}
