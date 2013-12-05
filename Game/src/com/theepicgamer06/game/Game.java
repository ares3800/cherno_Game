package com.theepicgamer06.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.theepicgamer06.game.Input.KeyBoard;
import com.theepicgamer06.game.Input.Mouse;
import com.theepicgamer06.game.entity.mob.Player;
import com.theepicgamer06.game.graphics.Screen;
import com.theepicgamer06.game.graphics.Sprite;
import com.theepicgamer06.game.level.Level;
import com.theepicgamer06.game.level.LevelSpawn;
import com.theepicgamer06.game.level.TileCoordinate;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 5537878534475685633L;
	private static int width = 300;
	private static int height = width / 16 * 9;
	public static int scale = 3;
	public double max_Fps = 60;

	private Thread thread;
	private KeyBoard key;
	private JFrame frame;
	private Player player;
	private Level level;
	private boolean running = false;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		level = new LevelSpawn("/textures/level.png");

		key = new KeyBoard();
		addKeyListener(key);

		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);

		TileCoordinate PlayerSpawn = new TileCoordinate(8, 8);
		player = new Player(PlayerSpawn.x(), PlayerSpawn.y(), key);
		player.init(level);
	}
	
	public static int getWindowWidth(){
		return width * scale;
	}
	
	public static int getWindowheight(){
		return height * scale;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long LastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / max_Fps;
		double delta = 0;
		int Frames = 0;
		int updates = 0;
		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - LastTime) / ns;
			LastTime = now;
			while (delta >= 1) {
				updates++;
				update();
				delta--;
			}
			render();
			Frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(Frames + " FPS " + updates + " updates");
				Frames = 0;
				updates = 0;
				frame.setTitle("Rain | " + Frames + " FPS " + updates
						+ " Updates");
			}
		}
	}

	public void update() {
		key.update();
		player.update();
		level.update();
		if (key.esc)
			System.exit(1);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xscroll = player.x - screen.width / 2;
		int yscroll = player.y - screen.height / 2;
		level.Render(xscroll, yscroll, screen);
		player.render(screen);

		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		//g.fillRect(mouse.getX() - 32, mouse.getY() - 32, 64, 64);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);
		game.frame.setLocationRelativeTo(null);

		game.start();
	}

}
