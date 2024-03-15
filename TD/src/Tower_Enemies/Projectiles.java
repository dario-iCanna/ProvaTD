package Tower_Enemies;

import HitInfos.HitBox;

public class Projectiles {
	
	private int x, y, eX, eY, width, heigth, perforanza, damage, hit = -1, diffX, diffY;
	private double velocity, angle;
	private double uX, uY, ipo, movX = 0, movY = 0;
	private HitBox hitBox;
	
	public Projectiles(int x, int y, HitBox e, int width, int heigth, double velocity, int perforanza, int damage) {
		super();
		this.x = x;
		this.y = y;
		this.eX = (int)(e.calcolaCentro().getX());
		this.eY = (int)(e.calcolaCentro().getY());;
		this.width = width;
		this.heigth = heigth;
		this.velocity = velocity;
		this.perforanza = perforanza;
		this.damage = damage;

		calcolaVettore();

	}
	
	public void calcolaVettore() {
		diffX = eX - x;
		diffY = eY - y;
		
		ipo = Math.sqrt(diffY * diffY + diffX * diffX);
		uX = diffX/ipo;
		uY = diffY/ipo;
		if(diffY > 0) {
			angle = Math.asin(diffX/ipo) * -1;			
		}
		else {
			angle = Math.asin(diffX/ipo);	
		}
		x = (int) (x - (width/2) * Math.cos(angle));
		y = (int) (y - (width/2) * Math.sin(angle));
		hitBox = new HitBox(x, y, width, heigth, angle);
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

	public int geteX() {
		return eX;
	}

	public void seteX(int eX) {
		this.eX = eX;
	}

	public int geteY() {
		return eY;
	}

	public void seteY(int eY) {
		this.eY = eY;
	}

	public HitBox getHitBox() {
		return hitBox;
	}

	public void setHitBox(HitBox hitBox) {
		this.hitBox = hitBox;
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

	public void updatePos() {
		movX += uX * velocity;
		movY += uY * velocity;
		if(movX <= -1 || movX >= 1) {
			x += (int)(movX);
			movX -= (int)(movX);
		}
		
		if(movY <= -1 || movY >= 1) {
			y += (int)(movY);
			movY -= (int)(movY);
		}
		
		hitBox = new HitBox(x, y, width, heigth, angle);
	}
	
	public boolean isOut() {
		if(y <= 200) {
			return true;
		}
		else if(y >= 1000) {
			return true;
		}
		else if(x >= 1000) {
			return true;
		}
		else if(x <= 0) {
			return true;
		}
		return false;
	}
	
	public void perforazione() {
		perforanza--;
	}
	
	public int getPerforanza() {
		return perforanza;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public int getHit() {
		return hit;
	}

	public double getIpo() {
		return ipo;
	}

	public void setIpo(double ipo) {
		this.ipo = ipo;
	}

	public int getDiffX() {
		return diffX;
	}

	public int getDiffY() {
		return diffY;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}