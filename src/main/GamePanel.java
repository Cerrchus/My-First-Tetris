package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	// Tamaño del JPanel
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public GamePanel() {
		// Configuracion del JPanel
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
	}
}
