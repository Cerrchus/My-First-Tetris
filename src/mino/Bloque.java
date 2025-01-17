package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bloque extends Rectangle {
	
	public int y, x;
	public static final int SIZE = 30;
	public Color c;
	
	public Bloque(Color c) {
		this.c = c;
	}
	
	public void dibujo(Graphics2D g2) {
		g2.setColor(c);
		g2.fillRect(x,y, SIZE, SIZE);
	}

}
