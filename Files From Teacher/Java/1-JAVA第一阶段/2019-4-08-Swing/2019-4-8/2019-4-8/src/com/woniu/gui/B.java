package com.woniu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class B implements ActionListener {
	JTextField tf1;
	JTextField tf2;
	public B(JTextField tf1,JTextField tf2){
		this.tf1 = tf1;
		this.tf2 = tf2;
	}

	public void actionPerformed(ActionEvent e) {
		this.tf1.setText("");
		this.tf2.setText("");

	}

}
