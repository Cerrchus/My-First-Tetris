package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhandler implements KeyListener {
	
	public static boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == e.getKeyCode().VK_W) {
			upPressed = true;
		}
		if(code == e.getKeyCode().VK_A) {
			upPressed = true;
		}
		if(code == e.getKeyCode().VK_S) {
			upPressed = true;
		}
		if(code == e.getKeyCode().VK_D) {
			upPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
