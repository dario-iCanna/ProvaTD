package Tower_Enemies;

import Main.GamePanel;

public class Rounds {
	private boolean active;
	private int bonus = 100, max = 9;
	private GamePanel gamePanel;
	private int cont = 0, frame = 0, round = 0;
	private int[] ene, time;
	public Rounds(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		active = false;
		assignRound();
	}
	
	public int enemyInd(int ind) {
		cont++;
		return ene[ind];
	}
	
	public boolean upCount() {
		if(cont == 0 && active) {
			return true;
		}
		else if(cont < time.length && active) {
			frame++;
			if(frame >= time[cont]) {
				frame = 0;
				return true;
			}
		}
		else if(active && gamePanel.empty()) {
			active = false;
			cont = 0;
			frame = 0;
			gamePanel.money  += bonus;
			gamePanel.resetAttacks();
			bonus--;
			round++;
		}
		return false;
	}
	
	public void upRound() {
		if(!active) {
			assignRound();
			active = true;
		}
		
	}
	
	public void assignRound() {
		
		switch(round) {
		case 0:
			int temp0[] = {0,0,0,0,0,0,0,0,0};
			ene = temp0;
			int temp0t[] = {60,60,60,60,60,60,60,60,60};
			time = temp0t;
			break;
		case 1:
			int temp1[] = {0};
			ene = temp1;
			int temp1t[] = {60};
			time = temp1t;
		}
	}
	
	public int getCont() {
		return cont;
	}
	
	public boolean isActive() {
		return active;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
}
