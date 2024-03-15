package Tower_Enemies;

import java.awt.Point;
import java.util.ArrayList;

import HitInfos.HitBox;

public class Enemy {

	private int x,y;
	private int width,heigth, hitted = -1;
	private double pos = 0;
	private double velocity;
	public Percorso percorso;
	private int ind;
	private int life;
	private int initialLife;

	private HitBox hitBox;
	
	public Enemy(int x, int y, int ind, Percorso percorso) {
		this.x = x;
		this.y = y;
		this.ind = ind;
		this.percorso = percorso;
		hitted = -1;
		
		
		switch(ind) {
		case 0:
			width = 10;
			heigth = 10;
			life = 1;
			velocity = 1;
			break;
		case 1:
			width = 20;
			heigth = 10;
			life = 4;
			velocity = 1;
			break;
		case 2:
			width = 10;
			heigth = 10;
			life = 4;
			velocity = 1;
			break;
		case 3:
			width = 20;
			heigth = 20;
			life = 2;
			velocity = 4;
			break;
		case 4:
			width = 30;
			heigth = 30;
			life = 3;
			velocity = 1.5;
			break;
		}
		initialLife = life;
		hitBox = new HitBox(x,y,width,heigth, 0);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public HitBox getHitBox() {
		return hitBox;
	}

	public void setHitBox(HitBox hitBox) {
		this.hitBox = hitBox;
	}	
	
	public void setPos(int x ,int y) {
		this.x = x;
		this.y = y;
		hitBox = new HitBox(x,y,width,heigth, 0);
	}
	
	public void avanza() {
		pos += velocity;
		if(pos < percorso.getPercorso().size()) {
			this.x = (int) (percorso.getPercorso().get((int)pos).getX()+ percorso.getWidth()/2 - width/2);
			this.y = (int) (percorso.getPercorso().get((int)pos).getY()+ percorso.getHeigth()/2 - heigth/2);
			hitBox = new HitBox(x,y,width,heigth, 0);
		}
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void reduceLife(int damage) {
		life-= damage;
	}

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

	public int getHitted() {
		return hitted;
	}

	public void setHitted(int hitted) {
		this.hitted = hitted;
	}
	
	public double getPos() {
		return pos;
	}
	
	public int getInitialLife() {
		return initialLife;
	}
}