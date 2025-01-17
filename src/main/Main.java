package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		// JFrame Principal
		JFrame window = new JFrame("Tetris");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		// Añadimos el JPanel a la ventana principal
		GamePanel gp = new GamePanel();
		window.add(gp);
		window.pack(); // Con este metodo el tamaño del GamePanel es el tamaño del JFrame	
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
