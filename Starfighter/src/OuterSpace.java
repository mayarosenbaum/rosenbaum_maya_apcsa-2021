import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class OuterSpace extends Canvas implements KeyListener, Runnable {
	private Ship ship;
	private Ammo a;
	private boolean fired;
	private boolean alien;
	private boolean af1;
	private boolean af2;
	private boolean game;
	private AlienHorde horde;
	private Bullets shots;
	private int alienSpeed;
	private int round;
	private Random ran;
  private int lives;
	private int r;
	private int g;
	private int b;
  private boolean lost;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace() {
		setBackground(Color.black);
		keys = new boolean[5];
		ship = new Ship(350, 400, 100, 100, 3);
		round = 0;
		alienSpeed = 2;
		alien = true;
		af1 = false;
		af2 = false;
		game = true;
    lives = 3;
    lost = false;
		ran = new Random();
		a = new Ammo((ship.getX() + ship.getWidth() / 2) - 5, ship.getY() - 5,
				5);
		horde = new AlienHorde(22);
		shots = new Bullets();
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
    if (!lost){
		  if (alien == true) {
		  	horde.generateHorde(115, 35, 40, 40, alienSpeed);
	  		alien = false;
	  	}
    	Graphics2D twoDGraph = (Graphics2D) window;
	    if (back == null)
	  	  back = (BufferedImage) (createImage(getWidth(), getHeight()));
	    Graphics graphToBack = back.createGraphics();
	    graphToBack.setColor(Color.BLACK);
  	  graphToBack.fillRect(0, 0, 800, 600);
	  	if (keys[0] == true) {
	  		if (ship.getX() > 0 - (ship.getWidth() / 2) + 2) {
	  			ship.move("LEFT");
	  		}
	  	}
	  	if (keys[1] == true) {
	  		if (ship.getX() < 800 - (ship.getWidth() / 2) - 18) {
	  			ship.move("RIGHT");
	  		}
	  	}
	  	if (keys[2] == true) {
	  		if (ship.getY() > 0 - 18) {
	  			ship.move("UP");
  			}
	  	}
  	  if (keys[3] == true) {
	  		if (ship.getY() < 600 - ship.getHeight() / 2 - 50) {
	  			ship.move("DOWN");
	  		}
	  	}

  		if (keys[4] == true && fired == true) {
	  		shots.add(new Ammo((ship.getX() + ship.getWidth() / 2) - 5, ship.getY() - 5, 5));
	  	}
    	ship.draw(graphToBack);
	  	shots.drawEmAll(graphToBack);
	  	shots.moveEmAll();
	  	horde.drawEmAll(graphToBack);
	  	horde.moveEmAll(shots);
	  	horde.removeDeadOnes(shots);
	  	shots.cleanEmUp();
	  	if (horde.getSize() == 0) {
	  		graphToBack.setColor(Color.WHITE);
	  		graphToBack.setFont(new Font(Font.SANS_SERIF, 250, 250));
	  		graphToBack.drawString("GG", 25, 300 - 40);
	  	}
	  	if (horde.hasCollided(ship)) {
        lives--;
	  	}
      for (Ammo a : shots.getList()){
        if (a.getSpeed() < 0 && a.didCollide(ship)){
          lives--;
        }
      }
	  	graphToBack.setFont(new Font(Font.SANS_SERIF, 24, 24));
	  	graphToBack.setColor(Color.WHITE);
	  	graphToBack.setFont(new Font(Font.SANS_SERIF, 24, 24));
	  	graphToBack.drawString("SCORE: " + horde.getScore(), 335, 30);
	  	graphToBack.drawString("LIVES: " + lives, 500, 30);
	    if (lives <= 0){
        lost = true;
	  		graphToBack.setColor(Color.RED);
	  		graphToBack.setFont(new Font(Font.SANS_SERIF, 250, 250));
	  		graphToBack.drawString("GAME", 25, 300 - 40);
	  		graphToBack.drawString("OVER", 25, 510 - 40);
      }
		  twoDGraph.drawImage(back, null, 0, 0);
	    fired = false;
		  back = null;
    }
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			fired = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_4) {
			af1 = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			af2 = true;
		}
//		if (e.getKeyCode() == KeyEvent.VK_V) {
//			lazer = true;
//		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_4) {
			af1 = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			af2 = false;
		}
		// if (e.getKeyCode() == KeyEvent.VK_SPACE)
		// {
		// keys[4] = false;
		// }
//		if (e.getKeyCode() == KeyEvent.VK_V) {
//			lazer = false;
//		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case ' ':
			keys[4] = true;
			break;
		}
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}