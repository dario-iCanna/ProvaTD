package Tower_Enemies;

public class PowerUp {
	private int pW, pH, damage, cost;
	private String nome;
	private int recharge;
	private boolean hadIt = false;
	private double velocity;
	private int perforanza;
	private int area;

	public PowerUp(String nome,int pW, int pH, int damage, int cost, int recharge, double velocity, int perforanza, int area) {
		this.nome = nome;
		this.pW = pW;
		this.pH = pH;
		this.damage = damage;
		this.cost = cost;
		this.recharge = recharge;
		this.velocity = velocity;
		this.perforanza = perforanza;
		this.area = area;
		hadIt = false;
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

	public int getRecharge() {
		return recharge;
	}

	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public int getPerforanza() {
		return perforanza;
	}

	public void setPerforanza(int perforanza) {
		this.perforanza = perforanza;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
	public boolean HadIt() {
		return hadIt;
	}
	
	public void setHadIt(boolean x) {
		hadIt = x;
	}
	
	public String getNome() {
		return nome;
	}
}
