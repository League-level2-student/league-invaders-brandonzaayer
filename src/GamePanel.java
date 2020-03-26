import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Rocketship r;
    public GamePanel() {
    	titleFont  = new Font("Arial", Font.PLAIN, 48);
    	Timer frameDraw = new Timer(1000/60,this);
    	frameDraw.start();
    	r = new Rocketship(250, 600, 50, 50);
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
	void updateMenuState() {
		
	}
	void updateGameState() {
		
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		r.draw(g);
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
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    r.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
			    r.down();
			    }
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
			    r.left();
			    }
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
			    r.right();
			    }
		}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
