package com.theepicgamer06.game.entity.projectile;

import java.util.Random;

import com.theepicgamer06.game.entity.Entity;
import com.theepicgamer06.game.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x,y;
	protected double nx,ny;
	protected double Distence;
	protected double Speed,RateOfFire,Range,Damage;
	
	protected final Random rand = new Random();
	
	public Projectile(int x,int y,double dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	public Sprite GetSprite(){
		return sprite;
	}
	
	public int GetSpriteSize(){
		return sprite.SIZE;
	}
}
