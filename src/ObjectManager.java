import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>(); 
ArrayList<Alien> aliens = new ArrayList<Alien>(); 
Random random = new Random();
public ObjectManager(Rocketship ship) {
	this.rocket = ship;
}
void addProjectile(Projectile p) {
	projectiles.add(p);
}
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update() {
	for(int i = 0; i < aliens.size(); i++){
		aliens.get(i).update();
	}
	for(int i = 0; i < projectiles.size(); i++){
		projectiles.get(i).update();
	}
}
void draw(Graphics g) {
	rocket.draw(g);
	for(int i = 0; i < aliens.size(); i++){
		aliens.get(i).draw(g);
	}
	for(int i = 0; i < projectiles.size(); i++){
		projectiles.get(i).draw(g);
	
}
}
void purgeObjects() {
	for(int i = aliens.size(); i > 0; i--){
		if(aliens.get(i).isActive == false) {
			aliens.remove(i);
		}
	}
	for(int i =  projectiles.size(); i > 0; i--){
		if(projectiles.get(i).isActive == false) {
			projectiles.remove(i);
		}
}
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
}
