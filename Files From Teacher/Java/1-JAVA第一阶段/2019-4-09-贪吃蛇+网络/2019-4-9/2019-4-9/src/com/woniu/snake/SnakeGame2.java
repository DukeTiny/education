package com.woniu.snake;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame2 extends JFrame implements KeyListener{
	//�����ߵ�ͷ
	JButton head = new JButton("ͷ");
	//�����ߵ�����
	JButton[] snake = new JButton[10];
	//����ʳ��
	JButton food = new JButton("ʳ");
	//�����±�
	int index;
	//��������
	int direction = 39;
	//�����ٶ�
	int speed = 300;
	//������ʱ��
	Timer timer;
	//��Ⱥ͸߶�
	int width = 50;
	int height = 50;
	
	public SnakeGame2(){
		//���ò��ֹ�����
		this.setLayout(null);
		//������
		head.setBounds(0, 0, width, height);
		this.add(head);
		food.setSize(width,height);
		this.setFoodLocation();
		this.add(food);
		
		timer = new Timer(this.speed, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				follow();
				move();
				eatFood();
			}
		});
		
		timer.start();
		
		snake[index++] = head;
		
		//��Ӽ���
		head.addKeyListener(this);
		
		//������ĸ�����
		this.setSize(617,638);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		
		head.requestFocus();
	}
	
	//�ƶ�����
	public void move(){
		int moveX = head.getX();
		int moveY = head.getY();
		switch(direction){
			case 37:
				if(moveX==0){
					moveX=600;
				}
				moveX-=this.width;
				break;
			case 38:
				if(moveY==0){
					moveY=600;
				}
				moveY-=this.height;
				break;
			case 39:
				if(moveX==600){
					moveX=-this.width;
				}
				moveX+=this.width;
				break;
			case 40:
				if(moveY==600){
					moveY=-this.height;
				}
				moveY+=this.height;
				break;
			
		}
		head.setLocation(moveX, moveY);
	}
	
	//��ʳ��
	public void eatFood(){
		if(head.getX()==food.getX()&&head.getY()==food.getY()){
			Point p = this.setFoodLocation();
			while(!this.isOver((int)p.getX(), (int)p.getY())){
				p = this.setFoodLocation();
			}
			food.setLocation(p);
			this.grow();
		}
	}
	
	//��������ʳ��λ��
	public Point setFoodLocation(){
		Random random = new Random();
		int x = random.nextInt(10)*this.width;
		int y = random.nextInt(10)*this.width;
		Point p = new Point(x, y);
		return p;
	}
	
	//������
	public void grow(){
		JButton body = new JButton("��");
		body.setSize(this.width,this.height);
		body.setLocation(head.getX(), head.getY());
		this.add(body);
		
		snake[index++] = body;
	}
	
	//�������
	public void follow(){
		for(int i=index-1;i>0;i--){
			snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
		}
	}
	
	//�ж�ʳ���Ƿ��������غ�
	public boolean isOver(int x,int y){
		for(int i=0;i<index;i++){
			if(snake[i].getX()==x&&snake[i].getY()==y){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Math.abs(e.getKeyCode()-direction)!=2){
			this.direction = e.getKeyCode();
		}
	}

	public static void main(String[] args) {
		new SnakeGame2();
	}
}
