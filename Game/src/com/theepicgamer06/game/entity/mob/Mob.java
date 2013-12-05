package com.theepicgamer06.game.entity.mob;


import java.util.ArrayList;
import java.util.List;

import com.theepicgamer06.game.entity.Entity;
import com.theepicgamer06.game.entity.projectile.Projectile;
import com.theepicgamer06.game.entity.projectile.Wizardprojectile;
import com.theepicgamer06.game.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;// North 0, East 1, South 2, West 3
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		if (!collision(xa, 0)) {
			x += xa;
		}
		if (!collision(0, ya)) {
			y += ya;
		}
		
	}

	public void update() {
	}
	
	protected void shoot(int x,int y,double dir) {
		Projectile p = new Wizardprojectile(x, y, dir);
		level.add(p);
	}

	private boolean collision(int xa, int ya) {
		boolean Solid = false;

		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid())
				Solid = true;
		}

		return Solid;
	}
	public void render() {

	}

}
