package com.woniu.tank.controll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.woniu.tank.bean.Player;
import com.woniu.tank.ui.TankPanel;

public class Controller implements KeyListener {
	Player p1;
	public Controller(Player p){
		this.p1 = p;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = p1.getX();
		int y = p1.getY();
		switch(e.getKeyCode()){
			case 32:
				
				break;
			case 37:
				p1.setDirection(3);
				if(TankPanel.level[y][x-1]==0||TankPanel.level[y][x-1]==1){
					p1.setX(p1.getX()-1);
				}
				break;
			case 38:
				p1.setDirection(2);
				if(TankPanel.level[y-1][x]==0||TankPanel.level[y-1][x]==1){
					p1.setY(p1.getY()-1);
				}
				break;
			case 39:
				p1.setDirection(1);
				if(TankPanel.level[y][x+1]==0||TankPanel.level[y][x+1]==1){
					p1.setX(p1.getX()+1);
				}
				break;
			case 40:
				p1.setDirection(0);
				if(TankPanel.level[y+1][x]==0||TankPanel.level[y+1][x]==1){
					p1.setY(p1.getY()+1);
				}
				break;
		}
		p1.getTp().repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
