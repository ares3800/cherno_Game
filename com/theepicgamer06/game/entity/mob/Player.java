package com.theepicgamer06.game.entity.mob;

import com.theepicgamer06.game.Input.KeyBoard;
import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class Player extends Mob {
	
	private KeyBoard input;
	public Sprite sprite;
	public int anim = 0;
	private boolean walking = false;
	
	public Player(KeyBoard input){
		this.input = input;
		sprite = sprite.player_f;
	}
	
	public Player(int x, int y,KeyBoard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = sprite.player_f;
	}
	
	public void update(){
		int xa=0,ya=0;
		if(input.up)ya--;
		if(input.down)ya++;
		if(input.left)xa--;
		if(input.right)xa++;
		
		if(xa != 0 || ya != 0){
			move(xa,ya);
			walking = true;
		}else{
			walking = false;
		}
	}
	
	public void render(Screen screen){
		if(dir == 2){
			sprite = sprite.player_f;
			if(walking){
				if(anim % 20 == 0){
					sprite = sprite.player_f_1;
				}else sprite = sprite.player_f_2;
			}
		}
		if(dir == 3){
			sprite = sprite.player_l;
			if(walking){
				if(anim % 20 == 0){
					sprite = sprite.player_l_1;
				}else sprite = sprite.player_l_2;
			}
		}
		if(dir == 0){
			sprite = sprite.player_b;
			if(walking){
				if(anim % 20 == 0){
					sprite = sprite.player_b_1;
				}else sprite = sprite.player_b_2;
			}
		}
		if(dir == 1){
			sprite = sprite.player_r;
			if(walking){
				if(anim % 20 == 0){
					sprite = sprite.player_r_1;
				}else sprite = sprite.player_r_2;
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite);
	}
	
	
}
