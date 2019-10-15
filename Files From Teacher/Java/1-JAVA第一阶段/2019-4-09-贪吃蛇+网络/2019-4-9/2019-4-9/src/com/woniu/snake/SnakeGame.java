package com.woniu.snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame extends JFrame implements KeyListener {
	JButton head = new JButton("头");
	JButton food = new JButton("食");
	JButton[] snake = new JButton[3];
	int index = 0;
	Timer timer;
	int direction = 39;
	int speed = 500;
	public SnakeGame(){
		this.setLayout(null);
		
		head.setBounds(0, 0, 60, 60);
		this.add(head);
		
		this.randFood();
		this.add(food);
		startGame();
				
		timer.start();
		snake[index++] = head;
		head.addKeyListener(this);
		
		this.setSize(617,638);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
	/**
	 * 身体跟随头动，后一身体占前一个身体的位置
	 */
	private void follow() {
		for(int i=index-1;i>0;i--){
			snake[i].setLocation(snake[i-1].getX(),snake[i-1].getY());
		}
		
	}
	/**
	 * 当头和食物重叠，食物重新定位
	 */
	private void eatFood() {
		if(head.getX()==food.getX()&&head.getY()==food.getY()){
			randFood();
			grow();
		}
	}
	/**
	 * 当吃到食物后，生成身体，添加蛇数组中，并把身体添加到界面中
	 */
	private void grow() {
		if(index<snake.length){
			JButton body = new JButton("身");	
			snake[index++] = body;
			body.setSize(head.getWidth(),head.getHeight());
			body.setLocation(head.getX(), head.getY());
			this.add(body);
		}else{
			timer.stop();
			for(int i=1;i<index;i++){
				this.remove(snake[i]);
			}
			snake = new JButton[3];
			index = 0;
			snake[index++] = head;
			speed-=100;
			startGame();
			timer.start();
		}
	}
	
	public void startGame(){
		timer = new Timer(speed, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//身体跟随
				follow();
				//头的移动
				int moveX = head.getX();
				int moveY = head.getY();
				switch(direction){
					case 37:
						if(moveX==0){
							moveX=600;
						}
						moveX-=head.getWidth();
						break;
					case 38:
						if(moveY==0){
							moveY=600;
						}
						moveY-=head.getHeight();
						break;
					case 39:
						if(moveX==600){
							moveX=-60;
						}
						moveX+=head.getWidth();
						break;
					case 40:
						if(moveY==600){
							moveY=-60;
						}
						moveY+=head.getHeight();
						break;
						
				}
				head.setLocation(moveX,moveY);
				//吃食物
				eatFood();
			}
			
		});

	}
	public void randFood(){
		//食物不能随机到身体上
		int x = (int)(Math.random()*2)*60;
		int y = (int)(Math.random()*2)*60;
		food.setSize(60, 60);
		for(int i=0;i<index;i++){
			if(snake[i].getX()==x&&snake[i].getY()==y){
				System.out.println(x+":"+y);
				randFood();
			}
		}
		food.setLocation(x, y);
	}
	
	public static void main(String[] args) {
		new SnakeGame();
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
		// TODO Auto-generated method stub
		if(Math.abs(e.getKeyCode()-direction)!=2){
			direction = e.getKeyCode();
		}
	}
}
