import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame j;
	final int WIDTH = 500;
	final int HEIGHT = 800;
public static void main(String[] args) {
	LeagueInvaders game = new LeagueInvaders();
	game.setup();
}
public LeagueInvaders() {
	 j = new JFrame();
}
void setup() {
	j.setSize(WIDTH, HEIGHT);
	j.setVisible(true);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
