package com.theepicgamer06.game.entity;

import java.util.Random;

import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.level.Level;

public abstract class Entity {
	
	public int x,y;
	private boolean removed =  false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		// Remove From Level
		removed = true;
	}
	
	public boolean isremoved(){
		//Checks is the entity removed
		return removed;
	}
	
	
}
