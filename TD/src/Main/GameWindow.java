package Main;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	public GameWindow(GamePanel gamePanel) {
		super.setTitle("Battle of Ages");
		super.add(gamePanel);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
}
