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
		//���ò��ֹ�����
//		this.setLayout(new BorderLayout());  //��ʽ���� ���϶��£���������
// BorderLayout �߽粼�� �����ϱ���
		
//		this.add(b1,BorderLayout.CENTER);
//		this.add(b2,BorderLayout.NORTH);
//		this.add(b3,BorderLayout.SOUTH);
//		this.add(b4,BorderLayout.EAST);
//		this.add(b5,BorderLayout.WEST);
		
		//���񲼾� GridLayout 
//		this.setLayout(new GridLayout(2, 2));
//		this.add(b1);
//		this.add(b2);
//		this.add(b3);
//		this.add(b4);
//		this.add(b5);
		
		//�޲���
		this.setLayout(null);
		//�趨ÿ������Ĵ�С��λ��
//		b1.setSize(150,30);
//		b1.setLocation(0,0);
		b1.setBounds(0, 0, 50, 30);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		
		
		//����JFrame��С
		this.setSize(400,300);
		//����λ��
		this.setLocation(50, 100);
		//���ÿ���
		this.setVisible(true);
		//���ý���رշ�ʽ
		//JFrame.EXIT_ON_CLOSE �رս��沢�˳�����
		//DISPOSE_ON_CLOSE �رս��沢���ٵ�ǰ����
		//HIDE_ON_CLOSE ���ؽ���
		//DO_NOTHING_ON_CLOSE ʲô��������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		JFrameDemo fd = new JFrameDemo();
	}
}
