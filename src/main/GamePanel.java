package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	// Tamaño del JPanel
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	final int FPS = 60; 
	Thread gameThread;
	PlayManager pm;
	
	public GamePanel() {
		// Configuracion del JPanel
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
<<<<<<< HEAD
		//implements KeyListener
		this.addKeyListener(new KeyHandler());
		this.setFocusable(isFocusable());
=======
		pm = new PlayManager();
>>>>>>> 3438a515f08b2f43b6ea17792280c5d94d2ff3cc
		
	}
	
	public void launchGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	@Override
	public void run() {
		 // Game Loop
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	
	private void update() {
		pm.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		pm.draw(g2);
		
	}
}
