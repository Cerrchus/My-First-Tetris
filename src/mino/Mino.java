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
<<<<<<< HEAD
	public void updateXY(int direction) {
		
		this.direction = direction;
		tempB[0].x = b[0].x;
    	tempB[0].y = b[0].y;
    	tempB[1].x = b[1].x;
    	tempB[1].y = b[1].y;
    	tempB[2].x = b[2].x;
    	tempB[2].y = b[2].y;
    	tempB[3].x = b[3].x;
    	tempB[3].y = b[3].y;
	}
	public void getDirection1() {}
	public void getDirection2() {}
	public void getDirection3() {}
	public void getDirection4() {}
	public void update() {
		
		//Movement
		if(KeyHandler.upPressed) {
			switch(direction) {
			case 1: getDirection2();break;
			case 2: getDirection3();break;
			case 3: getDirection4();break;
			case 4: getDirection1();break;
			}
			KeyHandler.upPressed = false;
		}
		if(KeyHandler.downPressed) {
=======
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
>>>>>>> f011dad792e241e754cad5fd27f6a48413197e36
			
			b[0].y += Block.SIZE;
			b[1].y += Block.SIZE;
			b[2].y += Block.SIZE;
			b[3].y += Block.SIZE;
		    autoDropCounter = 0;  //AL DESPLAZARSE HACIA ABAJO SE REINICIA EL AUTODROP
		    KeyHandler.downPressed = false;
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
