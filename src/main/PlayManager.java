package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import mino.Block;
import mino.Mino;
import mino.Mino_Bar;
import mino.Mino_L1;
import mino.Mino_L2;
import mino.Mino_Square;
import mino.Mino_T;
import mino.Mino_Z1;
import mino.Mino_Z2;

public class PlayManager {

    // Dimensiones
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

<<<<<<< HEAD
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    Mino nextMino;
    final int NEXTMINO_X;
    final int NEXTMINO_Y;
    public static ArrayList<Block> staticBlocks = new ArrayList<>();

    // Otras
    public static int dropInterval = 60;
    boolean gameOver;

    // Niveles
    int level = 1;
    int lines;
    int score;
=======
	// Actualiza el siguiente mino
	public void update() {
		
		//Revisa si la partida ha terminado
		if (currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y) {
			gameOver = true;
		}
		currentMino.update();

		if(currentMino.active == false) {
			staticBlocks.add(currentMino.b[0]);
			staticBlocks.add(currentMino.b[1]);
			staticBlocks.add(currentMino.b[2]);
			staticBlocks.add(currentMino.b[3]);
			
			currentMino.deactivating = false;
			
			currentMino = nextMino;
			currentMino.setXY(MINO_START_X, MINO_START_Y);
			nextMino = pickMino();
			nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
			
			checkDelete();
		} else {
			currentMino.update();
		}

	}
	
	public void checkDelete() {
		int x = left_x;
		int y = top_y;
		int blockCount = 0;
		while(x < right_x && y < bottom_y) {
			for(int i = 0; i < staticBlocks.size(); i++) {
				if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {
					blockCount++;
				}
			}
			x += Block.SIZE;
			if(x == right_x) {
				
				if(blockCount == 12) {
					for(int i = staticBlocks.size()-1; i > -1; i--) {
						// delete em
						if(staticBlocks.get(i).y == y) {
							staticBlocks.remove(i);
						}
					}
					for(int i = 0; i < staticBlocks.size(); i++) {
						// move em down
						if(staticBlocks.get(i).y < y) {
							staticBlocks.get(i).y += Block.SIZE;
						}
					}
				}
				
				blockCount = 0;
				x = left_x;
				y += Block.SIZE;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		// Dibuja el rectangulo donde se juega
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(4f));
		g2.drawRect(left_x-4, top_y-4, WIDTH+8, HEIGHT+8);
		
		// Dibuja el siguiente mino
		int x = right_x + 100;
		int y = bottom_y - 200;
		g2.drawRect(x, y, 280, 200);
		g2.setFont(new Font("Arial", Font.PLAIN, 30));
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("SIGUIENTE", x+60, y+60);
		
		// Dibuja el mino actual 
		if(currentMino != null) {
			currentMino.draw(g2);
		}
		
		//Dibuja el nivel
		
		g2.drawRect(x, top_y, 250, 300);
		x +=40;
		y = top_y + 90;
		g2.drawString("NIVELES: " + level, x, y); y+= 70;
		g2.drawString("LINEA: " + level, x, y); y+= 70;
		g2.drawString("MARCADOR: " + level, x, y);
		//nextMino
		nextMino.draw(g2);

		for(int i = 0; i < staticBlocks.size(); i++) {
			staticBlocks.get(i).draw(g2);
		}
		
		// Dibuja la pausa
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(50f));
		if (gameOver) {
			x = left_x + 25;
			y = top_y + 320;
			g2.drawString("GAME OVER :(", x, y);
		}
		if(KeyHandler.pausePressed) {
			x = left_x + 70;
			y = top_y + 320;
			g2.drawString("PAUSED", x, y);
		}
		
		//Titulo de Tetris
		x = 35;
		y = top_y + 320;
		g2.setColor(Color.white);
		g2.setFont(new Font ("Times New Roman", Font.ITALIC, 60));
		g2.drawString("TETRIS ", x+20, y);
	}
}
>>>>>>> 06d2842e7ab11555a8ab99423a9c55e3df73574a

    // Constructor del área de juego
    public PlayManager() {
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH / 2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE;

        NEXTMINO_X = right_x + 175;
        NEXTMINO_Y = top_y + 500;

        currentMino = pickMino();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
        nextMino = pickMino();
        nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
    }

    private Mino pickMino() {
        Mino mino = null;
        int i = new Random().nextInt(7);

        switch (i) {
            case 0: mino = new Mino_L1(); break;
            case 1: mino = new Mino_L2(); break;
            case 2: mino = new Mino_Square(); break;
            case 3: mino = new Mino_Bar(); break;
            case 4: mino = new Mino_T(); break;
            case 5: mino = new Mino_Z1(); break;
            case 6: mino = new Mino_Z2(); break;
        }
        return mino;
    }

    // Actualiza el siguiente mino
    public void update() {
        if (!gameOver) { // Solo actualiza si el juego no ha terminado
            // Revisa si la partida ha terminado
            if (currentMino.active == false) {
                staticBlocks.add(currentMino.b[0]);
                staticBlocks.add(currentMino.b[1]);
                staticBlocks.add(currentMino.b[2]);
                staticBlocks.add(currentMino.b[3]);

                // Verifica si el mino no puede moverse desde su posición inicial
                if (currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y) {
                    gameOver = true; // El juego termina
                }

                currentMino.deactivating = false;

                // Cambia al siguiente mino
                currentMino = nextMino;
                currentMino.setXY(MINO_START_X, MINO_START_Y);
                nextMino = pickMino();
                nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);

                checkDelete();
            } else {
                currentMino.update();
            }
        }
    }

    public void checkDelete() {
        int x = left_x;
        int y = top_y;
        int blockCount = 0;
        while (x < right_x && y < bottom_y) {
            for (int i = 0; i < staticBlocks.size(); i++) {
                if (staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {
                    blockCount++;
                }
            }
            x += Block.SIZE;
            if (x == right_x) {
                if (blockCount == 12) {
                    for (int i = staticBlocks.size() - 1; i > -1; i--) {
                        // Elimina los bloques en la línea completa
                        if (staticBlocks.get(i).y == y) {
                            staticBlocks.remove(i);
                        }
                    }
                    for (int i = 0; i < staticBlocks.size(); i++) {
                        // Mueve los bloques hacia abajo
                        if (staticBlocks.get(i).y < y) {
                            staticBlocks.get(i).y += Block.SIZE;
                        }
                    }
                }
                blockCount = 0;
                x = left_x;
                y += Block.SIZE;
            }
        }
    }

    public void draw(Graphics2D g2) {
        // Dibuja el rectángulo donde se juega
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

        // Dibuja el siguiente mino
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 280, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("SIGUIENTE", x + 60, y + 60);

        // Dibuja el mino actual
        if (currentMino != null) {
            currentMino.draw(g2);
        }

        // Dibuja el nivel, líneas y puntuación
        g2.drawRect(x, top_y, 250, 300);
        x += 40;
        y = top_y + 90;
        g2.drawString("NIVEL: " + level, x, y); y += 70;
        g2.drawString("LÍNEA: " + lines, x, y); y += 70;
        g2.drawString("MARCADOR: " + score, x, y);

        // Dibuja el siguiente mino
        nextMino.draw(g2);

        // Dibuja los bloques estáticos
        for (Block block : staticBlocks) {
            block.draw(g2);
        }

        // Dibuja la pausa y el Game Over
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(50f));
        if (gameOver) {
            x = left_x + 25;
            y = top_y + 320;
            g2.drawString("GAME OVER :(", x, y);
        } else if (KeyHandler.pausePressed) {
            x = left_x + 70;
            y = top_y + 320;
            g2.drawString("PAUSADO", x, y);
        }

        // Título de Tetris
        x = 35;
        y = top_y + 320;
        g2.setColor(Color.white);
        g2.setFont(new Font("Times New Roman", Font.ITALIC, 60));
        g2.drawString("TETRIS", x + 20, y);
    }
}