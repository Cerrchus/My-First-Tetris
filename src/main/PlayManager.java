package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import mino.Block;
import mino.Mino;
import mino.Mino_Bar;
import mino.Mino_L1;
import mino.Mino_L2;
import mino.Mino_Square;
import mino.Mino_T;
import mino.Mino_Z1;
import mino.Mino_Z2;

public class PlayManager {

	// Dimensiones
	final int WIDTH = 360;
	final int HEIGHT = 600;
	public static int left_x;
	public static int right_x;
	public static int top_y;
	public  static int bottom_y;
	
	Mino currentMino;
	final int MINO_START_X;
	final int MINO_START_Y;
	
	Mino nextMino;
	final int NEXTMINO_X;
	final int NEXTMINO_Y;
	public static ArrayList<Block> staticBlocks = new ArrayList<>();
	
	//Otras
	public static int dropInterval = 60;
	
	// Constructor del area de juego
	public PlayManager() {
		left_x = (GamePanel.WIDTH/2) - (WIDTH/2);
		right_x = left_x + WIDTH;
		top_y = 50;
		bottom_y = top_y + HEIGHT;
		
		MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
		MINO_START_Y = top_y + Block.SIZE;
		
		NEXTMINO_X = right_x + 175;
		NEXTMINO_Y = top_y + 500;
		
		
		currentMino = pickMino();
		currentMino.setXY(MINO_START_X, MINO_START_Y);
		nextMino = pickMino();
		nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
		
	}
	
	private Mino pickMino() {
		Mino mino = null;
		int i = new Random().nextInt(7);
		
		switch(i) {
		case 0: mino = new Mino_L1();break;
		case 1: mino = new Mino_L2();break;
		case 2: mino = new Mino_Square();break;
		case 3: mino = new Mino_Bar();break;
		case 4: mino = new Mino_T();break;
		case 5: mino = new Mino_Z1();break;
		case 6: mino = new Mino_Z2();break;
		
		}
		return mino;
	}

	// Actualiza el siguiente mino
	public void update() {
		currentMino.update();
	}
	
	public void draw(Graphics2D g2) {
		// Dibuja el rectangulo donde se juega
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(4f));
		g2.drawRect(left_x-4, top_y-4, WIDTH+8, HEIGHT+8);
		
		// Dibuja el siguiente mino
		int x = right_x + 100;
		int y = bottom_y - 200;
		g2.drawRect(x, y, 280, 200);
		g2.setFont(new Font("Arial", Font.PLAIN, 30));
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("SIGUIENTE", x+60, y+60);
		
		// Dibuja el mino actual 
		if(currentMino != null) {
			currentMino.draw(g2);
		}
		
		//nextMino
		nextMino.draw(g2);
		
		// Dibuja la pausa
		g2.setColor(Color.yellow);
		g2.setFont(g2.getFont().deriveFont(50f));
		if(KeyHandler.pausePressed) {
			x = left_x + 70;
			y = top_y + 320;
			g2.drawString("PAUSED", x, y);
		}
	}
}


