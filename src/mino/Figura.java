package mino;

import java.awt.Color;
import java.awt.Graphics2D;

public class Figura {
	
	public Bloque b[] = new Bloque[4];
	public Bloque tempB[] = new Bloque[4];
	
	public void create(Color c) {
	    b[0] = new Bloque(c);
	    b[1] = new Bloque(c);
	    b[2] = new Bloque(c);
	    b[3] = new Bloque(c);
	    tempB[0] = new Bloque(c);
	    tempB[1] = new Bloque(c);
	    tempB[2] = new Bloque(c);
	    tempB[3] = new Bloque(c);
	}

	public void setXY(int x, int y) {}
	public void updateXY(int direction) {}
	public void update() {
		
	}

	public void draw(Graphics2D g2) {
		
	}

}
