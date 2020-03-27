import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("rocket.png");
		}
		// TODO Auto-generated constructor stub
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
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 
}
