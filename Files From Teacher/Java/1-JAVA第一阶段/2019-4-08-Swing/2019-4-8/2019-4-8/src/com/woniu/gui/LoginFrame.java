package com.woniu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	
	JLabel userNameLabel = new JLabel();
	JLabel userPwdLabel = new JLabel();
	JTextField userNameTf = new JTextField();
	JTextField userPwdTf = new JTextField();
	JButton loginButton = new JButton("login");
	JButton resetButton = new JButton("reset");
	
	public LoginFrame(){
		this.setTitle("XXX系统登录");
		
		//设置布局管理器
		this.setLayout(null);
		
		//设置组件的位置和大小
		userNameLabel.setBounds(10,10,80,30);
		userNameLabel.setText("用户名");//设置标签的文字
		userNameTf.setBounds(100,10,80,30);
		userPwdLabel.setBounds(10,40,80,30);
		userPwdLabel.setText("密    码");
		userPwdTf.setBounds(100,40,80,30);
		loginButton.setBounds(10,70,80,30);
		resetButton.setBounds(100,70,80,30);
		
		//添加事件的监听器
//		A a = new A();
		B b = new B(userNameTf,userPwdTf);
		resetButton.addActionListener(b);

		
		//添加组件
		this.add(userNameLabel);
		this.add(userPwdLabel);
		this.add(userNameTf);
		this.add(userPwdTf);
		this.add(loginButton);
		this.add(resetButton);
		
		this.setSize(600,450);
		this.setLocationRelativeTo(null);  //默认对谁居中
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
	
//	class A implements ActionListener{
//		
//		public void actionPerformed(ActionEvent e) {
//			userNameTf.setText("");
//			userPwdTf.setText("");
//		}
//		
//	}
	
}


