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
	//声明蛇的头
	JButton head = new JButton("头");
	//声明蛇的数组
	JButton[] snake = new JButton[10];
	//声明食物
	JButton food = new JButton("食");
	//声明下标
	int index;
	//声明方向
	int direction = 39;
	//声明速度
	int speed = 300;
	//声明计时器
	Timer timer;
	//宽度和高度
	int width = 50;
	int height = 50;
	
	public SnakeGame2(){
		//设置布局管理器
		this.setLayout(null);
		//添加组件
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
		
		//添加监听
		head.addKeyListener(this);
		
		//界面的四个方法
		this.setSize(617,638);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		
		head.requestFocus();
	}
	
	//移动方法
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
	
	//吃食物
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
	
	//重新设置食物位置
	public Point setFoodLocation(){
		Random random = new Random();
		int x = random.nextInt(10)*this.width;
		int y = random.nextInt(10)*this.width;
		Point p = new Point(x, y);
		return p;
	}
	
	//长身体
	public void grow(){
		JButton body = new JButton("身");
		body.setSize(this.width,this.height);
		body.setLocation(head.getX(), head.getY());
		this.add(body);
		
		snake[index++] = body;
	}
	
	//身体跟随
	public void follow(){
		for(int i=index-1;i>0;i--){
			snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
		}
	}
	
	//判断食物是否与身体重合
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
