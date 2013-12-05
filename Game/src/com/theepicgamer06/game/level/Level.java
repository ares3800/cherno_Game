package com.theepicgamer06.game.level;

import java.util.ArrayList;
import java.util.List;

import com.theepicgamer06.game.entity.Entity;
import com.theepicgamer06.game.entity.particle.Particle;
import com.theepicgamer06.game.entity.projectile.Projectile;
import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesint;	
	protected int[] tiles;
	
	private List<Entity> enities = new ArrayList<Entity>();
	public List<Projectile> projectiles = new ArrayList<Projectile>();
	public List<Particle> particles = new ArrayList<Particle>();
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesint = new int[width * height];
		generateLevel();
	}

	public Level(String Path) {
		loadlevel(Path);
	}

	protected void generateLevel() {

	}

	protected void loadlevel(String Path) {
		
	}

	public void update() {
		for(int i = 0; i < enities.size();i++){
			enities.get(i).update();
		}
		for(int i = 0; i < projectiles.size();i++){
			projectiles.get(i).update();
		}
		for(int i = 0; i < particles.size();i++){
			particles.get(i).update();
		}
		remove();
	}
	
	private void remove(){
		for(int i = 0; i < enities.size();i++){
			if(enities.get(i).isremoved()) enities.remove(i);
		}
		for(int i = 0; i < projectiles.size();i++){
			if(projectiles.get(i).isremoved()) projectiles.remove(i);
		}
		for(int i = 0; i < particles.size();i++){
			if(particles.get(i).isremoved()) particles.remove(i);
		}
	}
	
	public List<Projectile> getpProjectiles(){
		return projectiles;
	}

	private void time() {

	}
	
	public boolean Tilecolision(int x,int y,int size, int xOffset, int yOffset) {
		boolean Solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * size + xOffset) >> 4;
			int yt = (y - c / 2 * size + yOffset) >> 4;
			if (getTile(xt, yt).solid())
				Solid = true;
			}
	return Solid;
	}

	public void Render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);

			}
		}
		for(int i = 0; i < enities.size();i++){
			enities.get(i).render(screen);
		}
		for(int i = 0; i < projectiles.size();i++){
			projectiles.get(i).render(screen);
		}
		for(int i = 0; i < particles.size();i++){
			particles.get(i).render(screen);
		}
	}
	public void add(Entity e){
		e.init(this);
		if(e instanceof Particle){
			particles.add((Particle) e);
		}else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);
		}else{
			enities.add(e);
		}
	}

	
	// Grass = 0xff00ff00
	// Flower = 0xffffff00
	// rock = 0xff7f7ff0
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)return Tile.Tilevoid;
		if (tiles[x + y * width] == 0xff00ff00)
			return Tile.TileGrass;
		if (tiles[x + y * width] == 0xffffff00)
			return Tile.TileGrass_flowers;
		if (tiles[x + y * width] == 0xff7f7ff0)
			return Tile.TileGrass_rocks;

		return Tile.TileGrass;

	}
}
