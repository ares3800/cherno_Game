package com.theepicgamer06.game.graphics;

public class AnimatedSprites extends Sprite {

	private int frame = 0;
	private Sprite sprite;
	private int rate = 5;
	private int time;
	private int length = -1;
	
	public AnimatedSprites(SpriteSheet sheet,int width , int height, int length){
		super(sheet,width,height);
		this.length = length;
		if( length >= sheet.getSprite().length) System.err.println("Error! AnimatedSprites.java, The lenth is to long");
	}
	
	public void update(){
		time++;
			if(time % rate == 0){
			if(frame >= length - 1) frame = 0;
			else frame++;
			sprite = sheet.getSprite()[frame];
		}
	}
	
	public Sprite getsprite(){
		return sprite;
	}
	
	public void setFrameRate(int frames){
		rate = frames;
	}
	
	
	
}
