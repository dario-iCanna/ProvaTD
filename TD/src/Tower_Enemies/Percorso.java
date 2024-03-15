package Tower_Enemies;

import java.awt.Point;
import java.util.ArrayList;

import HitInfos.HitBox;

public class Percorso {
	private double offset = 0, offsetX = 0, width = 40, heigth = 40;
	public ArrayList<Point> percorso;
	public ArrayList<HitBox> hitBox;
	
	public Percorso(){
        percorso = new ArrayList<Point>();
        hitBox = new ArrayList<HitBox>();

		
		for(int i = 0; i < 2400; i++) {
			if(i == 0) {
				percorso.add(new Point(0,450));
			}
			else if(i <= 100) {
				Riga(i,1,0,100,0);
			}
			else if(i <= 200) {
				Curva(i, false,true,200,100,true);
			}
			else if(i <= 300) {
				Riga(i,0,1,300,200);
			}
			else if(i <= 400) {
				Curva(i, true,true,400,300,true);
			}
			else if(i <= 550) {
				Riga(i,1,0,550,400);
			}
			else if(i <= 650) {
				Curva(i, false, true, 650, 550, false);
			}
			else if(i <= 900) {
				Riga(i, 0, -1, 900, 650);
			}
			else if(i <= 1000) {
				Curva(i,true,false,1000,900,false);
			}
			else if(i <= 1100) {
				Riga(i,-1,0,1100,1000);
			}
			else if(i<= 1150) {
				Curva(i,false,false,1150,1100,false);
			}
			else if(i <= 1200) {
				Riga(i,0,-1,1200,1150);
			}
			else if(i <= 1250) {
				Curva(i,true,true,1250,1200,false);
			}
			else if(i <= 1600) {
				Riga(i,1,0,1600,1250);
			}
			else if(i <= 1700) {
				Curva(i,false,true,1700,1600,true);
			}
			else if(i <= 1850) {
				Riga(i,0,1,1850,1700);
			}
			else if(i <= 1950) {
				Curva(i,true,true,1950,1850,true);
			}
			else {
				Riga(i,1,0,2400,1950);
			}
			hitBox.add(new HitBox((int)percorso.get(i).x,(int)percorso.get(i).y,(int)width,(int)heigth,0));
		}
		
	}

	public ArrayList<Point> getPercorso() {
		return percorso;
	}
	
	public void Riga(int i,double offsetX, double offset, int end, int ini) {
		this.offset += offset;
		this.offsetX += offsetX;
		percorso.add(new Point((int)(percorso.get(ini).x + this.offsetX), (int)(percorso.get(ini).y - this.offset)));
		if(i==end) {
			this.offset = 0;
			this.offsetX = 0;
		}
	}
	
	public ArrayList<HitBox> getHitBox() {
		return hitBox;
	}

	public double getWidth() {
		return width;
	}

	public double getHeigth() {
		return heigth;
	}

	public void Curva( int i,boolean reversed, boolean right, int end, int ini, boolean up) {
		int diff = Math.abs(end - ini);
		if(!reversed && right && up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + diff/10) {
				offset += 0.1;	
				offsetX += 0.9;
			}
			else if( i <= ini + (diff/10)*2) {
				offset += 0.2;		
				offsetX += 0.8;
			}
			else if( i <= ini + (diff/10)*3) {
				offset += 0.3;	
				offsetX += 0.7;
			}
			else if( i <= ini + (diff/10)*4) {
				offset += 0.4;	
				offsetX += 0.6;
			}
			else if( i <= ini + (diff/10)*5) {
				offset += 0.5;
				offsetX += 0.5;
			}
			else if( i <= ini + (diff/10)*6) {
				offset += 0.6;
				offsetX += 0.4;
			}
			else if( i <= ini + (diff/10)*7) {
				offset += 0.7;
				offsetX += 0.3;
			}
			else if( i <= ini + (diff/10)*8) {
				offset += 0.8;	
				offsetX += 0.2;
			}
			else if( i <= ini + (diff/10)*9) {
				offset += 0.9;	
				offsetX += 0.1;
			}
			else if( i <= end) {
				offset += 1;	
				offsetX += 0;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(!reversed && right && !up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + diff/10) {
				offset -= 0.1;	
				offsetX += 0.9;
			}
			else if( i <= ini + (diff/10)*2) {
				offset -= 0.2;		
				offsetX += 0.8;
			}
			else if( i <= ini + (diff/10)*3) {
				offset -= 0.3;	
				offsetX += 0.7;
			}
			else if( i <= ini + (diff/10)*4) {
				offset -= 0.4;	
				offsetX += 0.6;
			}
			else if( i <= ini + (diff/10)*5) {
				offset -= 0.5;
				offsetX += 0.5;
			}
			else if( i <= ini + (diff/10)*6) {
				offset -= 0.6;
				offsetX += 0.4;
			}
			else if( i <= ini + (diff/10)*7) {
				offset -= 0.7;
				offsetX += 0.3;
			}
			else if( i <= ini + (diff/10)*8) {
				offset -= 0.8;	
				offsetX += 0.2;
			}
			else if( i <= ini + (diff/10)*9) {
				offset -= 0.9;	
				offsetX += 0.1;
			}
			else if( i <= end) {
				offset -= 1;	
				offsetX += 0;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(!reversed && !right && up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + diff/10) {
				offset += 0.1;	
				offsetX -= 0.9;
			}
			else if( i <= ini + (diff/10)*2) {
				offset += 0.2;		
				offsetX -= 0.8;
			}
			else if( i <= ini + (diff/10)*3) {
				offset += 0.3;	
				offsetX -= 0.7;
			}
			else if( i <= ini + (diff/10)*4) {
				offset += 0.4;	
				offsetX -= 0.6;
			}
			else if( i <= ini + (diff/10)*5) {
				offset += 0.5;
				offsetX -= 0.5;
			}
			else if( i <= ini + (diff/10)*6) {
				offset += 0.6;
				offsetX -= 0.4;
			}
			else if( i <= ini + (diff/10)*7) {
				offset += 0.7;
				offsetX -= 0.3;
			}
			else if( i <= ini + (diff/10)*8) {
				offset += 0.8;	
				offsetX -= 0.2;
			}
			else if( i <= ini + (diff/10)*9) {
				offset += 0.9;	
				offsetX -= 0.1;
			}
			else if( i <= end) {
				offset += 1;	
				offsetX -= 0;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(!reversed && !right && !up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + diff/10) {
				offset -= 0.1;	
				offsetX -= 0.9;
			}
			else if( i <= ini + (diff/10)*2) {
				offset -= 0.2;		
				offsetX -= 0.8;
			}
			else if( i <= ini + (diff/10)*3) {
				offset -= 0.3;	
				offsetX -= 0.7;
			}
			else if( i <= ini + (diff/10)*4) {
				offset -= 0.4;	
				offsetX -= 0.6;
			}
			else if( i <= ini + (diff/10)*5) {
				offset -= 0.5;
				offsetX -= 0.5;
			}
			else if( i <= ini + (diff/10)*6) {
				offset -= 0.6;
				offsetX -= 0.4;
			}
			else if( i <= ini + (diff/10)*7) {
				offset -= 0.7;
				offsetX -= 0.3;
			}
			else if( i <= ini + (diff/10)*8) {
				offset -= 0.8;	
				offsetX -= 0.2;
			}
			else if( i <= ini + (diff/10)*9) {
				offset -= 0.9;	
				offsetX -= 0.1;
			}
			else if( i <= end) {
				offset -= 1;	
				offsetX -= 0;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(reversed && right && !up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + (diff/10)) {
				offset -= 1;	
				offsetX += 0;
			}
			else if( i <= ini + (diff/10)*2) {
				offset -= 0.9;		
				offsetX += 0.1;
			}
			else if( i <= ini + (diff/10)*3) {
				offset -= 0.8;	
				offsetX += 0.2;
			}
			else if( i <= ini + (diff/10)*4) {
				offset -= 0.7;	
				offsetX += 0.3;
			}
			else if( i <= ini + (diff/10)*5) {
				offset -= 0.6;
				offsetX += 0.4;
			}
			else if( i <= ini + (diff/10)*6) {
				offset -= 0.5;
				offsetX += 0.5;
			}
			else if( i <= ini + (diff/10)*7) {
				offset -= 0.4;
				offsetX += 0.6;
			}
			else if( i <= ini + (diff/10)*8) {
				offset -= 0.3;	
				offsetX += 0.7;
			}
			else if( i <= ini + (diff/10)*9) {
				offset -= 0.2;	
				offsetX += 0.8;
			}
			else if( i <= end) {
				offset -= 0.1;	
				offsetX += 0.9;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(reversed && right && up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + (diff/10)) {
				offset += 1;	
				offsetX += 0;
			}
			else if( i <= ini + (diff/10)*2) {
				offset += 0.9;		
				offsetX += 0.1;
			}
			else if( i <= ini + (diff/10)*3) {
				offset += 0.8;	
				offsetX += 0.2;
			}
			else if( i <= ini + (diff/10)*4) {
				offset += 0.7;	
				offsetX += 0.3;
			}
			else if( i <= ini + (diff/10)*5) {
				offset += 0.6;
				offsetX += 0.4;
			}
			else if( i <= ini + (diff/10)*6) {
				offset += 0.5;
				offsetX += 0.5;
			}
			else if( i <= ini + (diff/10)*7) {
				offset += 0.4;
				offsetX += 0.6;
			}
			else if( i <= ini + (diff/10)*8) {
				offset += 0.3;	
				offsetX += 0.7;
			}
			else if( i <= ini + (diff/10)*9) {
				offset += 0.2;	
				offsetX += 0.8;
			}
			else if( i <= end) {
				offset += 0.1;	
				offsetX += 0.9;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(reversed && !right && up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + (diff/10)) {
				offset += 1;	
				offsetX -= 0;
			}
			else if( i <= ini + (diff/10)*2) {
				offset += 0.9;		
				offsetX -= 0.1;
			}
			else if( i <= ini + (diff/10)*3) {
				offset += 0.8;	
				offsetX -= 0.2;
			}
			else if( i <= ini + (diff/10)*4) {
				offset += 0.7;	
				offsetX -= 0.3;
			}
			else if( i <= ini + (diff/10)*5) {
				offset += 0.6;
				offsetX -= 0.4;
			}
			else if( i <= ini + (diff/10)*6) {
				offset += 0.5;
				offsetX -= 0.5;
			}
			else if( i <= ini + (diff/10)*7) {
				offset += 0.4;
				offsetX -= 0.6;
			}
			else if( i <= ini + (diff/10)*8) {
				offset += 0.3;	
				offsetX -= 0.7;
			}
			else if( i <= ini + (diff/10)*9) {
				offset += 0.2;	
				offsetX -= 0.8;
			}
			else if( i <= end) {
				offset += 0.1;	
				offsetX -= 0.9;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
		else if(reversed && !right && !up) {
			percorso.add(new Point((int)(percorso.get(ini).x + offsetX), (int)(percorso.get(ini).y - offset)));
			if( i <= ini + (diff/10)) {
				offset -= 1;	
				offsetX -= 0;
			}
			else if( i <= ini + (diff/10)*2) {
				offset -= 0.9;		
				offsetX -= 0.1;
			}
			else if( i <= ini + (diff/10)*3) {
				offset -= 0.8;	
				offsetX -= 0.2;
			}
			else if( i <= ini + (diff/10)*4) {
				offset -= 0.7;	
				offsetX -= 0.3;
			}
			else if( i <= ini + (diff/10)*5) {
				offset -= 0.6;
				offsetX -= 0.4;
			}
			else if( i <= ini + (diff/10)*6) {
				offset -= 0.5;
				offsetX -= 0.5;
			}
			else if( i <= ini + (diff/10)*7) {
				offset -= 0.4;
				offsetX -= 0.6;
			}
			else if( i <= ini + (diff/10)*8) {
				offset -= 0.3;	
				offsetX -= 0.7;
			}
			else if( i <= ini + (diff/10)*9) {
				offset -= 0.2;	
				offsetX -= 0.8;
			}
			else if( i <= end) {
				offset -= 0.1;	
				offsetX -= 0.9;
				if(i == end) {
					offset = 0;
					offsetX = 0;
				}
			}
		}
	}
}


