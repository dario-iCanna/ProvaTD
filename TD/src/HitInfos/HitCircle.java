package HitInfos;

import java.awt.geom.Ellipse2D;

public class HitCircle extends Hit{
	
	private int ray;
	Ellipse2D hitBox;
	
	public HitCircle(int x, int y, int ray) {
		super(x - ray/2,y - ray/2);
		this.ray = ray;
		hitBox = new Ellipse2D.Float(x - ray/2,y - ray/2,ray, ray);
	}
	
	public boolean CheckCollision(HitBox other) {
		return hitBox.contains(other.calcolaCentro());
	}
	
	public int getRay() {
		return ray;
	}

	public int getX() {
		return super.getX();
	}

	public int getY() {
		return super.getY();
	}

	public void setRay(int ray) {
		this.ray = ray;
	}
}
