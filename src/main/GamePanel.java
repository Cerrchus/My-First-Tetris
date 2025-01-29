package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    // Tamaño del JPanel
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;
    private Image backgroundImage;
    public static Sound music = new Sound();
    public static Sound se = new Sound();

    public GamePanel() {
        // Configuracion del JPanel
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);

        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon(GamePanel.class.getResource("/images/imgFondo.png")).getImage();

        // Implements KeyListener
        this.addKeyListener(new KeyHandler());
        this.setFocusable(isFocusable());

        pm = new PlayManager();
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
        
        music.play(0, true);
        music.loop();
    }

    @Override
    public void run() {
        // Game Loop
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        if (KeyHandler.pausePressed == false) {
            pm.update();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, this);

        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
    }
}
