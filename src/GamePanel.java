import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Rocketship r = new Rocketship(200, 500, 50, 50);
    ObjectManager object = new ObjectManager(r);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    Timer alienSpawn;
    public GamePanel() {
    	titleFont  = new Font("Arial", Font.PLAIN, 48);
    	Timer frameDraw = new Timer(1000/60,this);
    	frameDraw.start();
    	if (needImage) {
    	    loadImage ("space.png");
    	}
    	startGame();
    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		object.update();
		if(r.isActive == false) {
			currentState = END;
		}
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 100, 100);
		titleFont = new Font("Arial", Font.PLAIN, 28);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 125, 250);
		titleFont = new Font("Arial", Font.PLAIN, 28);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE for instructions", 75, 400);
	}
	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		object.draw(g);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString(object.getScore(), 450, 50);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 125, 100);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}
		else if(currentState == GAME){
		    updateGameState();
		}
		else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("Action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        alienSpawn.stop();
		        r = new Rocketship(200, 500, 50, 50);
		        object = new ObjectManager(r);
		    } else {
		        currentState++;
		        alienSpawn.start();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    r.up = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
			    r.down = true;
			    }
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
			    r.left = true;
			    }
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
			    r.right = true;
			    }
		if (e.getKeyCode()==KeyEvent.VK_SPACE && currentState == GAME) {
			object.addProjectile(r.getProjectile());
		}
		}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    r.up = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
			    r.down = false;
			    }
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
			    r.left = false;
			    }
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
			    r.right = false;
			    }
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void startGame(){
		 alienSpawn = new Timer(1000 , object);
		 alienSpawn.start();
	}
}
