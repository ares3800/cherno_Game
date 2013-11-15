package com.theepicgamer06.game.entity.mob;

import com.theepicgamer06.game.entity.Entity;
import com.theepicgamer06.game.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;// North 0 East 1 South 2 West 3
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		if(!collision()){
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	private boolean collision() {
		return false;
	}

	public void render() {

	}
}
