package mino;

import java.awt.Color;

public class Mino_L1 extends Mino {

	
    public Mino_L1() {
        create(Color.orange);
    }

    public void setXY(int x, int y) {
        // 	 ○
        // 	 ○
    	//   ○ ○
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE * 2;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE * 2;
    }
    
    public void getDriection1() {
        // 	 ○
        // 	 ○
    	//   ○ ○
    	tempB[0].x = b[0].x;
    	tempB[0].y = b[0].y;
    	tempB[1].x = b[0].x;
    	tempB[1].y = b[0].y - Block.SIZE;
    	tempB[2].x = b[0].x;
    	tempB[2].y = b[0].y + Block.SIZE;
    	tempB[3].x = b[0].x + Block.SIZE;
    	tempB[3].y = b[0].y + Block.SIZE;
    }
    public void getDriection2() {}
    public void getDriection3() {}
    public void getDriection4() {}
    
}