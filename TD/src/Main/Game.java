package Main;

public class Game implements Runnable{
	
	private final int FPS_SET = 60;
	private GamePanel gamePanel;
	private Thread gameLoop;
	
	public Game() {
		gamePanel = new GamePanel();
		new GameWindow(gamePanel);
		gameLoop = new Thread(this);
		gameLoop.run();
	}

	@Override
	public void run() {
		
		long previousTime = System.nanoTime();
		double timePerFrame = 1000000000.0 /FPS_SET;
		long now;
		
		while(true) {
			now = System.nanoTime();
			if(now - previousTime >= timePerFrame) {
				previousTime = now;
				gamePanel.repaint();
			}
			
		}
		
	}
}
