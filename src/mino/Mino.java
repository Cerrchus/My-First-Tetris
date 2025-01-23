package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import main.PlayManager;

public class Mino {
	
	public Block b[] = new Block[4];
	public Block tempB[] = new Block[4];
	int autoDropCounter = 0;
	
	// 4 directions
	public int direction = 1;
	
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
	//these are empty because they are overriden in each mino class
	public void getDirection1() {}
	public void getDirection2() {}
	public void getDirection3() {}
	public void getDirection4() {}
	public void update() {
		
		//Movement
		if(KeyHandler.downPressed) {
			b[0].y += Block.SIZE;
			b[1].y += Block.SIZE;
			b[2].y += Block.SIZE;
			b[3].y += Block.SIZE;
			
			//when moved down, reset the autoDropCounter
			autoDropCounter = 0;
			
			KeyHandler.downPressed = false;
		}
		if(KeyHandler.upPressed) {
			
		}
		if(KeyHandler.leftPressed) {
			b[0].x -= Block.SIZE;
			b[1].x -= Block.SIZE;
			b[2].x -= Block.SIZE;
			b[3].x -= Block.SIZE;
			KeyHandler.leftPressed = false;
		}
		if(KeyHandler.rightPressed) {
			b[0].x -= Block.SIZE;
			b[1].x -= Block.SIZE;
			b[2].x -= Block.SIZE;
			b[3].x -= Block.SIZE;
			KeyHandler.leftPressed = false;
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
