import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int WIDTH = 475;
	final static int HEIGHT = 600;
	GamePanel panel;
public static void main(String[] args) {
	LeagueInvaders game = new LeagueInvaders();
	game.setup();
}
public LeagueInvaders() {
	 frame = new JFrame();
	 panel = new GamePanel();
}
void setup() {
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	frame.addKeyListener(panel);
}
}
