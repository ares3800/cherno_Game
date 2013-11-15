package com.theepicgamer06.game.level.tile;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class TileVoid extends Tile {

	public TileVoid(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.RenderTile(x, y, TileGrass);
		
	}	
	
	public boolean solid(){
		return true;
	}

}
