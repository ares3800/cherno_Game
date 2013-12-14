package com.theepicgamer06.game.entity.mob;

import com.theepicgamer06.game.Game;
import com.theepicgamer06.game.Input.KeyBoard;
import com.theepicgamer06.game.Input.Mouse;
import com.theepicgamer06.game.entity.projectile.Projectile;
import com.theepicgamer06.game.entity.projectile.Wizardprojectile;
import com.theepicgamer06.game.graphics.AnimatedSprites;
import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class Player extends Mob {

	private KeyBoard input;
	public Sprite sprite;
	public int anim = 0;
	private boolean walking = false;
	private AnimatedSprites Player_down = new AnimatedSprites(Sprite.Player_down, 32, 32, 3);
	private AnimatedSprites Player_up = new AnimatedSprites(Sprite.Player_up, 32, 32, 3);
	private AnimatedSprites Player_left = new AnimatedSprites(Sprite.Player_left, 32, 32, 3);
	private AnimatedSprites Player_right = new AnimatedSprites(Sprite.Player_right, 32, 32, 3);
	
	Projectile p;
	private int firerate = 0;

	public Player(KeyBoard input) {
		this.input = input;
		sprite = Player_down;
	}

	public Player(int x, int y, KeyBoard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Player_down;
		firerate = Wizardprojectile.FIRERATE;
	}

	public void update() {
		Player_down.update();
		Player_up.update();
		Player_left.update();
		Player_right.update();
		
		if(firerate > 0) firerate--;
		int xa = 0, ya = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateshooting();
	}
	private void clear() {
		for(int i = 0; i < level.getpProjectiles().size();i++){
			Projectile p = level.getpProjectiles().get(i);
			if(p.isremoved()) level.getpProjectiles().remove(i);
		}
	}

	private void updateshooting() {
		if(Mouse.getButton()==1 && firerate <= 0 ){
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowheight() / 2;
			double dir = Math.atan2(dy,dx);
			shoot(x, y, dir);
			firerate = Wizardprojectile.FIRERATE;
			
		}
	}

	public void render(Screen screen) {
		if (dir == 2) {
			sprite = Player_down;
			if (walking) {
				if (anim % 20 == 0) {
					sprite = Player_down;
				} else
					sprite = Player_down;
			}
		}
		if (dir == 3) {
			sprite = Player_left;
			if (walking) {
				if (anim % 20 == 0) {
					sprite = Player_left;
				} else
					sprite = Player_left;
			}
		}
		if (dir == 0) {
			sprite = Player_down;
			if (walking) {
				if (anim % 20 == 0) {
					sprite = Player_down;
				} else
					sprite = Player_down;
			}
		}
		if (dir == 1) {
			sprite = Player_right;
			if (walking) {
				if (anim % 20 == 0) {
					sprite = Player_right;
				} else
					sprite = Player_right;
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite);
	}

}
