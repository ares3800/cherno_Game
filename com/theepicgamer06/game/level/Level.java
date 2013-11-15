package com.theepicgamer06.game.level;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.level.tile.Tile;
import com.theepicgamer06.game.level.tile.TileVoid;

public class Level {
	
	protected int width, height;
	protected int[] tilesint;	
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesint = new int[width * height];
		generateLevel();
	}

	public Level(String Path) {
		loadlevel(Path);
	}

	protected void generateLevel() {

	}

	protected void loadlevel(String Path) {
		
	}

	public void update() {

	}

	private void time() {

	}

	public void Render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);

			}
		}
	}
	// Grass = 0xff00ff00
	// Flower = 0xffffff00
	// rock = 0xff7f7ff0
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)return Tile.Tilevoid;
		if (tiles[x + y * width] == 0xff00ff00)
			return Tile.TileGrass;
		if (tiles[x + y * width] == 0xffffff00)
			return Tile.TileGrass_flowers;
		if (tiles[x + y * width] == 0xff7f7ff0)
			return Tile.TileGrass_rocks;

		return Tile.Tilevoid;

	}
}
