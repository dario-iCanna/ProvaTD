package Main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import HitInfos.HitBox;
import HitInfos.HitCircle;
import Inputs.MouseInputs;
import Tower_Enemies.Enemy;
import Tower_Enemies.Percorso;
import Tower_Enemies.Projectiles;
import Tower_Enemies.Rounds;
import Tower_Enemies.Tower;

public class GamePanel extends JPanel{
	
	private int frames = 0, mouseX = 0, mouseY = 0, sel = -1, tSel = -1;
	public int money = 210;
	private int lives = 100;
	private boolean gameOver = false;
	private Percorso percorso;
	private Rounds rounds = new Rounds(this);
	private long lastCheck;
	private MouseInputs mouseInputs;
	private ArrayList<HitBox> hitBoxButton;
	private ArrayList<HitBox> hitBoxPower;
	private ArrayList<Projectiles> projectiles;
	private ArrayList<Tower> tower;
	private ArrayList<Enemy> enemy;
	private Integer[] cost = {70,70,70,70,70};
	private Color[] towerC = new Color[5];
	private BufferedImage percorsoSprite;
	private BufferedImage blu;
	
	public GamePanel() {
		super.setBackground(Color.LIGHT_GRAY);
		mouseInputs = new MouseInputs(this);
		super.setFocusable(true);
		super.setPreferredSize(new Dimension(1000,790));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		lastCheck = System.currentTimeMillis();	
		hitBoxButton = new ArrayList<HitBox>();
		hitBoxPower = new ArrayList<HitBox>();
		tower = new ArrayList<Tower>();
		enemy = new ArrayList<Enemy>();
		projectiles = new ArrayList<Projectiles>();
		percorso = new Percorso();
		for(int i = 0; i < 5; i ++) {
			hitBoxButton.add(new HitBox(10 + 60* i,10,50,50, 0));
			if(i == 0) {
				towerC[i] = Color.blue;
			}
			else if(i == 1){
				towerC[i] = Color.red;
			}
			else if(i == 2){
				towerC[i] = Color.orange;
			}
			else if(i == 3){
				towerC[i] = Color.pink;
			}
			else if(i == 4){
				towerC[i] = Color.green;
			}
		}
		hitBoxPower.add(new HitBox(340, 40, 100, 150, 0));
		hitBoxPower.add(new HitBox(480, 40, 100, 150, 0));
		
		 try {
		      percorsoSprite = ImageIO.read(GamePanel.class.getResourceAsStream("/Percorso.png"));
		 } catch (IOException e) {
		      System.out.println("Immagine problema");
		 } 
		 
		 try {
		      blu = ImageIO.read(GamePanel.class.getResourceAsStream("/towerProva.png"));
		 } catch (IOException e) {
		      System.out.println("Immagine problema");
		 } 
	}
	
	public void paintComponent(Graphics f) {
		super.paintComponent(f);
		
		Graphics2D g = (Graphics2D) f;
		
		
		
		if(!gameOver) {
			//pulsanti:
			
			for(int i = 0; i < 5; i++) {
				g.setColor(Color.white);
				if(mouseY <200) {
					if(hitBoxButton.get(i).CheckCollision(mouseX, mouseY)) {
						g.setColor(Color.darkGray);
					}
				}
				HitBox box = hitBoxButton.get(i);
				g.fillRect(box.getX(), box.getY(), box.getWidth(), box.getHeigth());
				g.setColor(towerC[i]);
				g.fillOval(20 + 60 * i, 20, 30, 30);
				g.setColor(Color.black);
				g.drawString(Integer.toString(cost[i]), 20 + 60 * i, 80);
			}
			
			if (tSel != -1) {
				for(int i = 0; i < 2; i++) {
					HitBox box = hitBoxPower.get(i);
					if(tower.get(tSel).getPowerUp(i).HadIt()) {
						g.setColor(Color.blue);
					}
					else {
						g.setColor(Color.black);
					}
					g.drawString(tower.get(tSel).getPowerUp(i).getNome() + " " + tower.get(tSel).getPowerUp(i).getCost(), (int)box.getA().getX() + 5, (int)box.getA().getY() +15);
					g.drawLine((int)(box.getA().getX()), (int)(box.getA().getY()), (int)(box.getB().getX()),(int)(box.getB().getY()));
					g.drawLine((int)(box.getB().getX()), (int)(box.getB().getY()), (int)(box.getC().getX()),(int)(box.getC().getY()));
					g.drawLine((int)(box.getC().getX()), (int)(box.getC().getY()), (int)(box.getD().getX()),(int)(box.getD().getY()));
					g.drawLine((int)(box.getD().getX()), (int)(box.getD().getY()), (int)(box.getA().getX()),(int)(box.getA().getY()));
					
				}
			}
			
			g.setColor(Color.black);
			g.drawString("Lives: " + lives, 350, 25);
			g.drawString("Money: " + money, 500, 25);
			g.drawString("Rounds: " + (int)(rounds.getRound()+ 1) + "/" + (int)( rounds.getMax()+ 1), 650, 25);
			
			
			
			//vario:
			
			g.setColor(Color.black);		
			g.drawLine(0, 200, 1000, 200);
			
			
			
			//percorso:
			
			g.drawImage(percorsoSprite, 0,201,1000, 590,null);
			
			//torri:
			
			for(int i = 0; i< tower.size(); i++) {
				if(i == tSel) {
					g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
					g.setColor(Color.white);
					g.fillOval(tower.get(i).getHitArea().getX(), tower.get(i).getHitArea().getY(), tower.get(i).getHitArea().getRay(), tower.get(i).getHitArea().getRay());
					g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
				}
			}
			
			for(int i = 0; i < tower.size(); i++) {
			    g.setColor(towerC[tower.get(i).getInd()]);
				Graphics2D c = (Graphics2D) g.create();
				c.rotate(tower.get(i).getHitBox().getAngle(), tower.get(i).getX(), tower.get(i).getY());
				//c.fillOval(tower.get(i).getX() - tower.get(i).getHitBox().getWidth()/2, tower.get(i).getY() - tower.get(i).getHitBox().getHeigth()/2, tower.get(i).getHitBox().getWidth(), tower.get(i).getHitBox().getHeigth());
				c.drawImage(blu, tower.get(i).getX() - tower.get(i).getHitBox().getWidth()/2 - 5, tower.get(i).getY() - tower.get(i).getHitBox().getHeigth()/2, null);
				
				//c.drawImage(blu, tower.get(i).getX() - tower.get(i).getHitBox().getWidth()/2, tower.get(i).getY() - tower.get(i).getHitBox().getHeigth()/2, tower.get(i).getHitBox().getWidth(), tower.get(i).getHitBox().getHeigth(), null);
				c.drawRect(tower.get(i).getX() - tower.get(i).getHitBox().getWidth()/2, tower.get(i).getY() - tower.get(i).getHitBox().getHeigth()/2, tower.get(i).getHitBox().getWidth(), tower.get(i).getHitBox().getHeigth());
				c.rotate(0, tower.get(i).getX(), tower.get(i).getY());;
				c.dispose();
				tower.get(i).upCount();
			}
			
			if(sel != -1){
				g.setColor(towerC[sel]);
				Tower temp = new Tower(mouseX, mouseY, sel);
				g.fillOval(mouseX - temp.getHitBox().getWidth()/2, mouseY - temp.getHitBox().getHeigth()/2, temp.getHitBox().getWidth(), temp.getHitBox().getHeigth());
			}
			
			//proiettili:
			
			for(int i = 0; i < projectiles.size(); i++) {
				if(projectiles.get(i) != null) {
					Graphics2D c = (Graphics2D) g.create();
					c.rotate(projectiles.get(i).getHitBox().getAngle(), projectiles.get(i).getX(), projectiles.get(i).getY());
					c.fillRect(projectiles.get(i).getX(), projectiles.get(i).getY(), projectiles.get(i).getWidth(), projectiles.get(i).getHeigth());
				    HitBox box = projectiles.get(i).getHitBox();
					g.drawLine((int)(box.getA().getX()), (int)(box.getA().getY()), (int)(box.getB().getX()),(int)(box.getB().getY()));
					g.drawLine((int)(box.getB().getX()), (int)(box.getB().getY()), (int)(box.getC().getX()),(int)(box.getC().getY()));
					g.drawLine((int)(box.getC().getX()), (int)(box.getC().getY()), (int)(box.getD().getX()),(int)(box.getD().getY()));
					g.drawLine((int)(box.getD().getX()), (int)(box.getD().getY()), (int)(box.getA().getX()),(int)(box.getA().getY()));
					c.rotate(0, projectiles.get(i).getX(), projectiles.get(i).getY());;
					c.dispose();
					projectiles.get(i).updatePos();
					if(projectiles.get(i).isOut()) {
						projectiles.set(i, null);
					}
				}
				
				
			}
			
			//nemici:
			
			
			for(int i = 0 ; i < enemy.size(); i++) {
				if(enemy.get(i) != null) {
					HitBox box = enemy.get(i).getHitBox();
					g.setColor(Color.red);
					g.drawLine((int)(box.getA().getX()), (int)(box.getA().getY()), (int)(box.getB().getX()), (int)(box.getB().getY()));
					g.drawLine((int)(box.getB().getX()), (int)(box.getB().getY()), (int)(box.getC().getX()), (int)(box.getC().getY()));
					g.drawLine((int)(box.getC().getX()), (int)(box.getC().getY()), (int)(box.getD().getX()), (int)(box.getD().getY()));
					g.drawLine((int)(box.getD().getX()), (int)(box.getD().getY()), (int)(box.getA().getX()), (int)(box.getA().getY()));
					g.drawString(Integer.toString(enemy.get(i).getLife()), enemy.get(i).getX(), enemy.get(i).getY() - 10);
					g.fillOval(0 + enemy.get(i).getX(), 0 + enemy.get(i).getY(), enemy.get(i).getWidth(), enemy.get(i).getHeigth());					
					enemy.get(i).avanza();
					if(enemy.get(i).getX() >= 1000) {
						lives -= enemy.get(i).getLife();
						enemy.set(i, null);	
					}
				}
			}
			
			//round:
			
			if(rounds.upCount()) {
				enemy.add(new Enemy((int)percorso.getPercorso().get(0).getX(),(int)percorso.getPercorso().get(0).getY(),rounds.enemyInd(rounds.getCont()), percorso));
			}
			else if(!rounds.isActive()) {
				enemy.clear();
				projectiles.clear();
			}
			
			checkEnemy();
			
			if(lives <= 0) {
				gameOver = true;
			}
			
			if(rounds.getRound() == rounds.getMax() + 1) {
				gameOver = true;
			}
		}
		else {
			g.drawString("GAMEOVER", 500, 500);
		}
		
		//frames:
		frames++;
		
		if(System.currentTimeMillis() - lastCheck >= 1000L) {
			lastCheck = System.currentTimeMillis();
			System.out.println(frames);
			frames = 0;
		}
	}
	
	public void setPosition(int x, int y) {
		mouseX = x;
		mouseY = y;
	}
	
	public void setClick(int x, int y) {
		boolean change = true;
		
		if(tSel != -1 ) {
			for(int i = 0; i < 2; i++) {
				if(hitBoxPower.get(i).CheckCollision(x, y)) {
					if(money >= tower.get(tSel).getPowerUp(i).getCost() && !tower.get(tSel).getPowerUp(i).HadIt()) {
						money -= tower.get(tSel).getPowerUp(i).getCost();
						tower.get(tSel).powerUp(i);
						change = false;
					}
				}
			}
			
		}
		
		if(y > 200 && sel != -1) {
			boolean cont = false;
			for(int i = 0; i < tower.size(); i++) {
				if(tower.get(i).getHitBox().CheckCollision(new Tower(x,y,sel).getHitBox())) {
					cont = true;
				}
			}
			if(!cont) {
				for(int i = 0; i< 2250; i++) {
					if(percorso.getHitBox().get(i).CheckCollision(new Tower(x,y,sel).getHitBox())) {
						cont = true;
					}
				}
			}
			if(!cont) {
				//inizializza new torre
				Tower t = new Tower(x,y,sel);
				tower.add(t);
				tSel = tower.size() - 1;
				money -= t.getCost();
				
			}
			sel = -1;
		}
		else if(y > 200 && sel == -1 && change) {
			int t = tSel;
			for(int i = 0; i<tower.size(); i++) {
				if(tower.get(i).getHitBox().CheckCollision(x,y)) {
					tSel = i;
				}
			}
			if(tSel == t) {
				tSel = -1;
			}
		}
		else {
			for(int i = 0; i < 5; i++) {
				if(hitBoxButton.get(i).CheckCollision(x, y) && sel == -1 && money >= cost[i]) {
					sel = i;
					tSel = -1;
				}
			}
		}
		
		
		
		if(y < 100 && x > 900) {
			rounds.upRound();
		}
	}
	
	public void checkEnemy() {
		if(tower.size() > 0) {
			for(int i = 0; i < tower.size(); i++) {
				if(enemy.size() > 0) {
					for (int j = 0; j < enemy.size(); j++) {
						if(enemy.get(j) != null) {
							if(tower.get(i).getHitArea().CheckCollision(enemy.get(j).getHitBox()) && tower.get(i).isAttack()) {
								tower.get(i).setAttack(false);
								Projectiles p = new Projectiles(tower.get(i).getX(), tower.get(i).getY(), enemy.get(j).getHitBox(), tower.get(i).getpW(), tower.get(i).getpH(), tower.get(i).getVelocity(), tower.get(i).getPerforanza(), tower.get(i).getDamage());
							    projectiles.add(p);
					            tower.get(i).getHitBox().setAngle(p.getAngle());
							}
						}
					}
				}
			}
		}
		
		if(projectiles.size() > 0) {
			for(int i = 0; i < projectiles.size(); i++) {
				for(int j = 0; j < enemy.size(); j++) {
					if(enemy.get(j) != null && projectiles.get(i) != null) {
						boolean remove = false;
						boolean check = projectiles.get(i).getHitBox().CheckCollision(enemy.get(j).getHitBox());
						if((check && enemy.get(j).getHitted() != i && projectiles.get(i).getHit() != j)) {
							projectiles.get(i).perforazione();
							enemy.get(j).reduceLife(projectiles.get(i).getDamage());
							enemy.get(j).setHitted(i);
							projectiles.get(i).setHit(j);
						}
						if(projectiles.get(i).isOut()) {
							projectiles.set(i, null);
							remove = true;
						}
						else if(projectiles.get(i).getPerforanza() <= 0) {
							projectiles.set(i, null);
							remove = true;
						}
						
						if(enemy.get(j).getLife() <= 0) {
							money += enemy.get(j).getInitialLife();
							enemy.set(j, null);
						}
						
						if(remove) {
							j = enemy.size();
						}
					}
				}
			}
		}
	}
	
	public void addMoney(int money) {
		this.money += money;
	}
	
	public boolean empty() {
		int cont = 0;
		for(int i = 0; i < enemy.size(); i++) {
			if(enemy.get(i) != null) {
				cont++;
			}
		}
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i) != null) {
				cont++;
			}
		}
		
		if(cont != 0) {
			return false;
		}
		return true;
	}
	
	public void resetAttacks() {
		for(Tower t: tower) {
			t.setAttack(true);
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}