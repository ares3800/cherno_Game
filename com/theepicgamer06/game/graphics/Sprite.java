package com.theepicgamer06.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite Grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite Grass_flowers = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite Grass_rocks = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite Void = new Sprite(16, 0x008CF9);
	
	public static Sprite player_f = new Sprite(32,0,4,SpriteSheet.tiles);
	public static Sprite player_l = new Sprite(32,0,5,SpriteSheet.tiles);
	public static Sprite player_r = new Sprite(32,0,6,SpriteSheet.tiles);
	public static Sprite player_b = new Sprite(32,0,7,SpriteSheet.tiles);
	
	public static Sprite player_f_1 = new Sprite(32,1,4,SpriteSheet.tiles);
	public static Sprite player_l_1 = new Sprite(32,1,5,SpriteSheet.tiles);
	public static Sprite player_r_1 = new Sprite(32,1,6,SpriteSheet.tiles);
	public static Sprite player_b_1 = new Sprite(32,1,7,SpriteSheet.tiles);

	public static Sprite player_f_2 = new Sprite(32,2,4,SpriteSheet.tiles);
	public static Sprite player_l_2 = new Sprite(32,2,5,SpriteSheet.tiles);
	public static Sprite player_r_2 = new Sprite(32,2,6,SpriteSheet.tiles);
	public static Sprite player_b_2 = new Sprite(32,2,7,SpriteSheet.tiles);
	
	public static Sprite player_f_3 = new Sprite(32,3,4,SpriteSheet.tiles);
	public static Sprite player_l_3 = new Sprite(32,3,5,SpriteSheet.tiles);
	public static Sprite player_r_3 = new Sprite(32,3,6,SpriteSheet.tiles);
	public static Sprite player_b_3 = new Sprite(32,3,7,SpriteSheet.tiles);
	
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size,int color){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setcolor(color);
	}
	
	private void setcolor(int color){
		for(int i = 0; i < SIZE*SIZE; i++){
			pixels[i] = color;
		}
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.SIZE];

			}
		}
	}
}
