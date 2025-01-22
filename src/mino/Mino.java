package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import main.PlayManager;
import main.KeyHandler;

public class Mino {
	
	public Block b[] = new Block[4];
	public Block tempB[] = new Block[4];
	int autoDropCounter = 0;
	public int direction = 1; // Hay 4 direcciones (1, 2, 3 y 4)
	
	public void create(Color c) {
	    b[0] = new Block(c);
	    b[1] = new Block(c);
	    b[2] = new Block(c);
	    b[3] = new Block(c);
	    tempB[0] = new Block(c);
	    tempB[1] = new Block(c);
	    tempB[2] = new Block(c);
	    tempB[3] = new Block(c);
	}

	public void setXY(int x, int y) {}
	public void updateXY(int direction) {}
	public void getDirection1() {
		
	}
	public void getDirection2() {
			
		}
	public void getDirection3() {
		
	}
	public void getDirection4() {
		
	}
	public void update() {
		
		if(KeyHandler.upPressed) {
			
		}
		if(KeyHandler.downPressed) {
			b[0].y += Block.SIZE;
			b[1].y += Block.SIZE;
			b[2].y += Block.SIZE;
			b[3].y += Block.SIZE;
			autoDropCounter = 0;
			
			KeyHandler.downPressed = false;
		}
		if(KeyHandler.leftPressed) {
			b[0].y += Block.SIZE;
			b[1].y += Block.SIZE;
			b[2].y += Block.SIZE;
			b[3].y += Block.SIZE;
			autoDropCounter = 0;
			
			KeyHandler.leftPressed = false;
		}
		if(KeyHandler.rightPressed) {
			b[0].y += Block.SIZE;
			b[1].y += Block.SIZE;
			b[2].y += Block.SIZE;
			b[3].y += Block.SIZE;
			autoDropCounter = 0;
			
			KeyHandler.rightPressed = false;
		}
		
		autoDropCounter++; //sube con cada frame
		if(autoDropCounter == PlayManager.dropInterval) {
			//mino va por abajo
			b[0].y += Block.SIZE;
			b[1].y += Block.SIZE;
			b[2].y += Block.SIZE;
			b[3].y += Block.SIZE;
			autoDropCounter = 0;
		}
		
	}

	public void draw(Graphics2D g2) {
		
	}

}
