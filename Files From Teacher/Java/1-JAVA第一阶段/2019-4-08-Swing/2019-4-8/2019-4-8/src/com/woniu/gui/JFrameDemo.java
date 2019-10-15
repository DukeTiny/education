package com.woniu.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo  extends JFrame{
	JButton b1 = new JButton("b1");
	JButton b2 = new JButton("b2");
	JButton b3 = new JButton("b3");
	JButton b4 = new JButton("b4");
	JButton b5 = new JButton("b5");
	public JFrameDemo(){
		//设置布局管理器
//		this.setLayout(new BorderLayout());  //流式布局 自上而下，自左向右
// BorderLayout 边界布局 东西南北中
		
//		this.add(b1,BorderLayout.CENTER);
//		this.add(b2,BorderLayout.NORTH);
//		this.add(b3,BorderLayout.SOUTH);
//		this.add(b4,BorderLayout.EAST);
//		this.add(b5,BorderLayout.WEST);
		
		//网格布局 GridLayout 
//		this.setLayout(new GridLayout(2, 2));
//		this.add(b1);
//		this.add(b2);
//		this.add(b3);
//		this.add(b4);
//		this.add(b5);
		
		//无布局
		this.setLayout(null);
		//设定每个组件的大小和位置
//		b1.setSize(150,30);
//		b1.setLocation(0,0);
		b1.setBounds(0, 0, 50, 30);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		
		
		//设置JFrame大小
		this.setSize(400,300);
		//设置位置
		this.setLocation(50, 100);
		//设置可显
		this.setVisible(true);
		//设置界面关闭方式
		//JFrame.EXIT_ON_CLOSE 关闭界面并退出程序
		//DISPOSE_ON_CLOSE 关闭界面并销毁当前界面
		//HIDE_ON_CLOSE 隐藏界面
		//DO_NOTHING_ON_CLOSE 什么都不操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		JFrameDemo fd = new JFrameDemo();
	}
}
