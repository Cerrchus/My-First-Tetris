package mino;

import java.awt.Color;

public class FigL1 extends Figura {

	
    public FigL1() {
        create(Color.orange);
    }

    public void setXY(int x, int y) {
        // ○
        // ○
    	// ○ ○
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Bloque.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Bloque.SIZE * 2;
        b[3].x = b[0].x + Bloque.SIZE;
        b[3].y = b[0].y + Bloque.SIZE * 2;
    }
}

