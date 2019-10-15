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
		this.setTitle("XXXϵͳ��¼");
		
		//���ò��ֹ�����
		this.setLayout(null);
		
		//���������λ�úʹ�С
		userNameLabel.setBounds(10,10,80,30);
		userNameLabel.setText("�û���");//���ñ�ǩ������
		userNameTf.setBounds(100,10,80,30);
		userPwdLabel.setBounds(10,40,80,30);
		userPwdLabel.setText("��    ��");
		userPwdTf.setBounds(100,40,80,30);
		loginButton.setBounds(10,70,80,30);
		resetButton.setBounds(100,70,80,30);
		
		//����¼��ļ�����
//		A a = new A();
		B b = new B(userNameTf,userPwdTf);
		resetButton.addActionListener(b);

		
		//������
		this.add(userNameLabel);
		this.add(userPwdLabel);
		this.add(userNameTf);
		this.add(userPwdTf);
		this.add(loginButton);
		this.add(resetButton);
		
		this.setSize(600,450);
		this.setLocationRelativeTo(null);  //Ĭ�϶�˭����
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


