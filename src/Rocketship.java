import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
	public void right() {
		if(LeagueInvaders.WIDTH - x < 491) {
		x+=speed;
    }
	}
	public void left() {
		if(LeagueInvaders.WIDTH - x > 9) {
		x-=speed;
    }
	}
	public void up() {
		if(LeagueInvaders.HEIGHT - y > 9) {
		y-=speed;
		}
    }
	public void down() {
		if(LeagueInvaders.HEIGHT - y < 791) {
		y+=speed;
    }
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        System.out.println(x);
	}
}
