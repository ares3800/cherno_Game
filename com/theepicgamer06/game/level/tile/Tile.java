package com.theepicgamer06.game.level.tile;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class Tile {

	public static Tile TileGrass = new TileGrass(Sprite.Grass);
	public static Tile TileGrass_flowers = new TileGrassFlowers(Sprite.Grass_flowers);
	public static Tile TileGrass_rocks = new TileGrassRocks(Sprite.Grass_rocks);
	public static Tile Tilevoid = new TileVoid(Sprite.Void);
	
	public int x, y;
	public Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;

	}

	public void render(int x, int y, Screen screen) {
		
	}

	public boolean solid(){
		return false;
	}
}
