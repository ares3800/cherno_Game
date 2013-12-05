package com.theepicgamer06.game.entity.projectile;

import com.theepicgamer06.game.entity.spawner.ParticleSpawner;
import com.theepicgamer06.game.graphics.Screen;

public class Wizardprojectile extends Projectile {

	public static final int FIRERATE = 10;
	
	public Wizardprojectile(int x, int y, double dir) {
		super(x, y, dir);
		sprite = sprite.Projectile_wizard;
		Range = rand.nextInt(500)+10;
		Speed = 1;
		Damage = 50;
		RateOfFire = 10;

		nx = Speed * Math.cos(angle);
		ny = Speed * Math.sin(angle);
	}

	public void update() {
		move();
	}
	protected void move() {
		x += nx;
		y += ny;
		if(level.Tilecolision((int)(x + nx), (int)(y + nx), 7,5,4)){
		level.add(new ParticleSpawner((int)x, (int)y, 40, 5000000,level));
		remove();
		}
		if (Distance() > Range)
			remove();
	}

	private double Distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y)
				* (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.RenderProjectile((int) x - 12, (int) y - 2, this);
	}

}
