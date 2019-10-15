package com.woniu.tank;

import javax.swing.JFrame;

public class TankUI extends JFrame {
	TankPanel tankPanel = new TankPanel();
	public TankUI(){
		this.setContentPane(tankPanel);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TankUI();
	}

}
