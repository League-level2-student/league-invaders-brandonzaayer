import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>(); 
ArrayList<Alien> aliens = new ArrayList<Alien>(); 
Random random = new Random();
public ObjectManager(Rocketship rock) {
	rocket = rock;
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
}
}
