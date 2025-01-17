package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import main.PlayManager;

public class Mino {
	
	public Block b[] = new Block[4];
	public Block tempB[] = new Block[4];
	int autoDropCounter = 0;
	
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
	public void update() {
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
