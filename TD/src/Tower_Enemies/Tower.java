package Tower_Enemies;

import java.util.ArrayList;

import HitInfos.HitBox;
import HitInfos.HitCircle;

public class Tower {
	private int x,y,ind, pW, pH, damage, cost;
	private HitBox hitBox;
	private HitCircle hitArea;
	private ArrayList<PowerUp> power;
	private boolean attack;
	private int recharge;
	private int count = 0;
	private double velocity;
	private int perforanza;
	
	public Tower(int x, int y, int ind) {
		super();
		this.x = x;
		this.y = y;
		this.ind = ind;
		attack = true;
		power = new ArrayList<PowerUp>();
		//String nome,int pW, int pH, int damage, int cost, int recharge, double velocity, int perforanza, int area
		switch(ind) {
		case 0:
			hitBox = new HitBox(x - 15,y - 15,30,30, 0);
			hitArea = new HitCircle(x,y,300);
			velocity = 6.5;
			recharge = 60;
			perforanza = 1;
			pW=6;
			pH=7;
			damage = 1;
			cost = 70;
			power.add(new PowerUp("Area Mf",0, 0, 0, 70, 0, 0, 0, 40));
			power.add(new PowerUp("Perforanza Aument",0, 0, 0, 100, 0, 0, 1, 0));
			break;
		case 1:
			hitBox = new HitBox(x -5,y - 5,10,10, 0);
			hitArea = new HitCircle(x,y,100);
			velocity = 4.5;
			recharge = 60;
			perforanza = 3;
			pW=7;
			pH=8;
			damage = 1;
			cost = 70;
			power.add(new PowerUp("Cecchino",10, 10, 4, 70, 70, 40, -2, 500));
			power.add(new PowerUp("Max SPeed",0, 0, 0, 100, -100, 0, 0, 0));
			break;
		case 2:
			hitBox = new HitBox(x - 10,y - 10,20,20, 0);
			hitArea = new HitCircle(x,y,20);
			velocity = 4;
			recharge = 30;
			perforanza = 100;
			pW=10;
			pH=30;
			damage = 1;
			cost = 70;
			power.add(new PowerUp("Cecchino",5, 5, 4, 70, 70, 40, -2, 500));
			power.add(new PowerUp("Max SPeed",0, 0, 0, 100, -100, 0, 0, 0));
			break;
		case 3:
			hitBox = new HitBox((int)(x - 20),(int)(y - 20),40,40, 0);
			hitArea = new HitCircle(x,y,60);
			velocity = 3;
			recharge = 60;
			perforanza = 4;
			pW=10;
			pH=30;
			damage = 1;
			cost = 70;
			power.add(new PowerUp("Cecchino",5, 5, 4, 70, 70, 40, -2, 500));
			power.add(new PowerUp("Max SPeed",0, 0, 0, 100, -100, 0, 0, 0));
			break;
		case 4:
			hitBox = new HitBox(x - 10,y - 10,20,20, 0);
			hitArea = new HitCircle(x,y,100);
			velocity = 4;
			recharge = 120;
			perforanza = 1;
			pW=10;
			pH=30;
			damage = 1;
			cost = 70;
			power.add(new PowerUp("Cecchino",5, 5, 4, 70, 70, 40, -2, 500));
			power.add(new PowerUp("Max SPeed",0, 0, 0, 100, -100, 0, 0, 0));
			break;
		}		
	}
	
	
	public void upCount() {
		if(!attack) {
			count++;
		}
		
		if(count >= recharge) {
			attack = true;
			count = 0;
		}
	}
	
	public void powerUp(int i) {
		hitArea = new HitCircle(x,y,hitArea.getRay() + power.get(i).getArea());
		velocity += power.get(i).getVelocity();
		recharge += power.get(i).getRecharge();
		perforanza += power.get(i).getPerforanza();
		pW += power.get(i).getpW();
		pH += power.get(i).getpH();
		damage += power.get(i).getDamage();
		power.get(i).setHadIt(true);
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
	public int getInd() {
		return ind;
	}
	public void setInd(int ind) {
		this.ind = ind;
	}
	public HitBox getHitBox() {
		return hitBox;
	}
	public void setHitBox(HitBox hitBox) {
		this.hitBox = hitBox;
	}
	public boolean isAttack() {
		return attack;
	}
	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	public HitCircle getHitArea() {
		return hitArea;
	}
	public void setHitArea(HitCircle hitArea) {
		this.hitArea = hitArea;
	}

	public int getRecharge() {
		return recharge;
	}

	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getPerforanza() {
		return perforanza;
	}

	public void setPerforanza(int perforanza) {
		this.perforanza = perforanza;
	}

	public int getpW() {
		return pW;
	}

	public void setpW(int pW) {
		this.pW = pW;
	}

	public int getpH() {
		return pH;
	}

	public void setpH(int pH) {
		this.pH = pH;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public PowerUp getPowerUp(int i) {
		return power.get(i);
	}
}