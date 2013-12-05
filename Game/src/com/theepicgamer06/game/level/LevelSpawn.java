package com.theepicgamer06.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelSpawn extends Level {

	public LevelSpawn(String Path) {
		super(Path);
	}

	protected void loadlevel(String Path) {
		try {
			BufferedImage image = ImageIO.read(LevelSpawn.class
					.getResource(Path));
			this.width = image.getWidth();
			this.height = image.getHeight();
//				 int w = image.getWidth();
//				 int h = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);

		} catch (IOException e) {
			System.out.println("Error LevelSpawn.class Image not Found");
			e.printStackTrace();
		}
	}
	// Grass = 0xff00ff00
	// Flower = 0xffffff00
	// rock = 0xff7f7ff0
	protected void generateLevel() {
	}
}
