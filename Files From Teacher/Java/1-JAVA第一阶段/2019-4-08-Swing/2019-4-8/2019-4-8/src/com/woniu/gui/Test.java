package com.woniu.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Test extends JFrame {
	public Test(){
		this.setSize(600,450);
		this.setLocationRelativeTo(null);  //ƒ¨»œ∂‘À≠æ”÷–
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
