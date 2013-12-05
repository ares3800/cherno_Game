package com.theepicgamer06.game.entity.spawner;

import com.theepicgamer06.game.entity.Entity;
import com.theepicgamer06.game.entity.particle.Particle;
import com.theepicgamer06.game.level.Level;

public class Spawner extends Entity {
	
	public enum Type{
		MOB,PARTICLE
	}
	
	private Type type;
	
	public Spawner(int x,int y, Type type,int amount, Level level){
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}

}
