package com.theepicgamer06.game.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.theepicgamer06.game.entity.Entity;
import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;

public class Particle extends Entity {
	
	private List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;
	
	protected int life;
	private int time = 0;
	
	protected double xa,ya,za;
	protected double xx,yy,zz;
	
	public Particle(int x,int y,int life){
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(100)- 50);
		sprite = Sprite.praticle_normal;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat();
	}

	public void update(){
		time++;
		if(time >= Integer.MAX_VALUE - 1) time = 0;
		if(time > life) remove();
		
		za -= 0.1;
		if(zz < 0){
			zz = 0;
			za *= -0.5;
			xa *= 0.4;
			ya *= 0.4;
		}
		move(xx + xa, yy + ya + (zz+ za));
		
	}
	
	private void move(double x, double y){
		if(colision(x, y)){
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
		
	}
	
	public boolean colision(double x,double y) {
		boolean Solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = (x - c % 2 * 16) / 16;
			double yt = (y - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0) ix = (int) Math.floor(xt);
			if(c / 2 == 0) iy = (int) Math.floor(yt);
			if (level.getTile(ix, iy).solid())
				Solid = true;
			}
	return Solid;
	}
	
	public void render(Screen screen){
		screen.renderSprite((int)xx, (int)yy - (int) zz, sprite, true);
	}

}
