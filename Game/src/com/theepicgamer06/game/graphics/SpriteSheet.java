package com.theepicgamer06.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.SheetCollate;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	public final int WIDTH, HEIGHT;

	public static SpriteSheet tiles = new SpriteSheet(
			"/textures/spritesheet.png", 256);
	public static SpriteSheet Projectile_wizard = new SpriteSheet(
			"/textures/WizardProjectile.png", 48);
	public static SpriteSheet Player = new SpriteSheet("/textures/char.png",
			128, 96);
	public static SpriteSheet Player_up = new SpriteSheet(Player, 0, 0, 3, 1, 32);
	public static SpriteSheet Player_left = new SpriteSheet(Player, 0, 1, 3, 1, 32);
	public static SpriteSheet Player_right = new SpriteSheet(Player, 0, 2, 3, 1, 32);
	public static SpriteSheet Player_down = new SpriteSheet(Player, 0, 3, 3, 1, 32);
	
	private Sprite[] sprites;
	
	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height,int Spritesize) {
		int xx = x * Spritesize;
		int yy = y * Spritesize;
		int w = width * Spritesize;
		int h = height * Spritesize;
		if(width == height) SIZE = width;
		else
			SIZE = -1;
		
		WIDTH = w;
		HEIGHT = h;
		pixels = new int[w * h];
		for (int y0 = 0; y0 < h; y0++) {
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}
		int frame = 0;
		sprites = new Sprite[width*height];
		for(int ya = 0; ya < width; ya++){
			for(int xa = 0; xa < width; xa++){
				int[] Spritepixels = new int[Spritesize * Spritesize];
				for(int y0 = 0; y0 < Spritesize; y++){
					for(int x0 = 0; x0 < Spritesize; y++){
						Spritepixels[x0 + y0 * Spritesize] = pixels[(x0 + xa * Spritesize ) + (y0 + ya * Spritesize)];
						System.out.println("Run");
					}
				}

				Sprite sprite = new Sprite(Spritepixels, Spritesize, Spritesize);
				sprites[frame++] = sprite;
			}
		}
		

	}

	public SpriteSheet(String Path, int width, int height) {
		this.path = Path;
		SIZE = -1;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[width * height];
		load();
	}

	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		WIDTH = SIZE;
		HEIGHT = SIZE;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	public Sprite[] getSprite(){
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
