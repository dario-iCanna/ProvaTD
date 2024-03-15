package HitInfos;

import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class HitBox extends Hit{
	
	private int width, heigth;
	private double angle, xA, yA, area;
	private Point a,b,c,d;
	
	public HitBox(int x,int y, int width, int heigth, double angle) {
		super(x,y);
		this.width = width;
		this.heigth = heigth;
		this.angle = angle;
		calcolaVertici();
	}
	
	public boolean CheckCollision(HitBox other) {
		area = AreaHitBox(a,b,c,d);
		Point punto = other.calcolaCentro();
		return this.CheckCollision(punto.x, punto.y) ||
				this.CheckCollision((int)(other.getA().getX()), (int)(other.getA().getY())) ||
				this.CheckCollision((int)(other.getB().getX()), (int)(other.getB().getY())) || 
				this.CheckCollision((int)(other.getC().getX()), (int)(other.getC().getY())) ||
				this.CheckCollision((int)(other.getD().getX()), (int)(other.getD().getY())) || 
				other.CheckCollision(calcolaCentro().x,calcolaCentro().y) ||
				other.CheckCollision(a.x, a.y) || other.CheckCollision(b.x, b.y) ||
				other.CheckCollision(c.x, c.y) || other.CheckCollision(d.x, d.y);
	}
	
	public boolean CheckCollision(int x, int y) {
		area = AreaHitBox(a,b,c,d);
		Point punto = new Point(x,y);
		
		return (calculateTriangleArea(punto,a,b) + calculateTriangleArea(punto,b,c) + calculateTriangleArea(punto,c,d) + calculateTriangleArea(punto,d,a)) == area;
	}
	
	private double AreaHitBox(Point a,Point b, Point c, Point d) {
		return calculateTriangleArea(a,b,c) + calculateTriangleArea(a,d,c);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeigth() {
		return heigth;
	}
	
	private double calculateTriangleArea(Point a, Point b, Point c) {
		return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
	}
	
	public Point calcolaCentro() {
		Point m1 = new Point((int)((a.getX() + b.getX())/2), (int)((a.getY() + b.getY())/2));
		Point m2 = new Point((int)((c.getX() + c.getX())/2), (int)((d.getY() + d.getY())/2));
		Point center = new Point((int)((m1.getX() + m2.getX())/2), (int)((m1.getY() + m2.getY())/2));
		return center;
	}
	
	private void calcolaVertici() {
		xA = (x + (width) * Math.cos(angle));
		yA = (y + (width) * Math.sin(angle));
		double angoloTemp = Math.toRadians(180 - 90 -(180 - 90 - Math.toDegrees(angle)));
		a = new Point(x,y);
		b = new Point((int) xA,(int) yA);
		c = new Point((int) (xA - (heigth) * Math.sin(angoloTemp)),(int) (yA + (heigth) * Math.cos(angoloTemp)));
		d = new Point((int) (x - (heigth)*Math.cos(Math.toRadians(180 - 90 - Math.toDegrees(angle)))),(int) (y + (heigth)*Math.sin(Math.toRadians(180 - 90 - Math.toDegrees(angle)))));
	}
	
	public int getXA() {
		return (int)xA;
	}
	
	public int getYA() {
		return (int)yA;
	}

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getC() {
		return c;
	}

	public Point getD() {
		return d;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getAngle() {
		return angle;
	}
	
}
