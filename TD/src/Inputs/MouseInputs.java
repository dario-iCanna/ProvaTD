package Inputs;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import HitInfos.HitBox;
import Main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{

	private GamePanel gamePanel;
	private int i = 0;
	
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(i == 0) {
			gamePanel.setClick(e.getX(), e.getY());
			i++;
		}
		gamePanel.setPosition(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		gamePanel.setPosition(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gamePanel.setClick(e.getX(), e.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(i == 1) {
			gamePanel.setClick(e.getX(), e.getY());
			i = 0;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
