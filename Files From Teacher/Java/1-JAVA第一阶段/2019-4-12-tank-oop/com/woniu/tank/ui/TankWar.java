package com.woniu.tank.ui;

import javax.swing.JFrame;

public class TankWar extends JFrame {
	TankPanel tp = new TankPanel();
	
	public TankWar(){
		this.setContentPane(tp);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
	
}
