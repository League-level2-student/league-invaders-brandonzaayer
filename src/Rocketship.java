import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
	public void right() {
		if(x < 419) {
		x+=speed;
    }
		else{
			System.out.println("Stay inside the boundaries");
		}
	}
	public void left() {
		if(x > 00) {
		x-=speed;
    }
		else{
			System.out.println("Stay inside the boundaries");
		}
	}
	public void up() {
		if(y > 0) {
		y-=speed;
		}
		else{
			System.out.println("Stay inside the boundaries");
		}
    }
	public void down() {
		if(y < LeagueInvaders.HEIGHT - 50) {
		y+=speed;
    }
		else{
			System.out.println("Stay inside the boundaries");
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
}
