package com.theepicgamer06.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width,height;
	public int[] pixels;
	protected SpriteSheet sheet;

	public static Sprite Grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite Grass_flowers = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite Grass_rocks = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite Wall = new Sprite(16, 2, 0, SpriteSheet.tiles);
	
	public static Sprite Void = new Sprite(16, 0x008CF9);
	
	//Projectile
	public static Sprite Projectile_wizard = new Sprite(16, 0, 0, SpriteSheet.Projectile_wizard);
	
	//Particle
	public static Sprite praticle_normal = new Sprite(2,2,0xAAAAAA);
	
	
	
	//Player
	public static SpriteSheet Player_up = new SpriteSheet(SpriteSheet.Player, 0, 0, 3, 1, 32);
	public static SpriteSheet Player_left = new SpriteSheet(SpriteSheet.Player, 0, 1, 3, 1, 32);
	public static SpriteSheet Player_right = new SpriteSheet(SpriteSheet.Player, 0, 2, 3, 1, 32);
	public static SpriteSheet Player_down = new SpriteSheet(SpriteSheet.Player, 0, 3, 3, 1, 32);
	
	protected Sprite(SpriteSheet sheet ,int width,int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int width,int height,int color){
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setcolor(color);
	}
	
	public Sprite(int size,int color){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setcolor(color);
	}
	
	public Sprite(int[] Pixels,int width,int height){
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = Pixels;
	}
	
	private void setcolor(int color){
		for(int i = 0; i < width * height; i++){
			pixels[i] = color;
		}
	}
	
	public int getwidth(){
		return width;
	}
	
	public int getheight(){
		return height;
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
