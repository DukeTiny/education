package com.woniu.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.annotation.Resources;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TankPanel extends JPanel implements KeyListener{
	int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 0, 0, 0 },
					{ 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0 },
					{ 0, 2, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 0 },
					{ 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 0 },
					{ 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 5, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0 }
				};
	int width = 40;
	int height = 40;
	ArrayList<EnemyTank> enemyTanks = new ArrayList<EnemyTank>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	int i;
	int j;
	
	int direction = 2; //0下 1右 2上 3左	00 32 32
	
	
	public TankPanel() {
		EnemyTank tank1 = new EnemyTank(0, 0, this);
		EnemyTank tank2= new EnemyTank(6, 6, this);
		tank1.start();
		tank2.start();
		enemyTanks.add(tank1);
		enemyTanks.add(tank2);
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	Timer t;
	
	public void paint(Graphics g) {
		Image grass = new ImageIcon(Resources.class.getResource("/img/grass.png")).getImage();
		Image wall = new ImageIcon(Resources.class.getResource("/img/wall.gif")).getImage();
		Image steels = new ImageIcon(Resources.class.getResource("/img/steels.png")).getImage();
		Image player = new ImageIcon(Resources.class.getResource("/img/player.png")).getImage();
		Image bg = new ImageIcon(Resources.class.getResource("/img/bg.png")).getImage();
		Image boss = new ImageIcon(Resources.class.getResource("/img/boss1.gif")).getImage();
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), null);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					g.drawImage(grass, width * j, height * i, this.width, this.height, null);
				}
				if (map[i][j] == 2) {
					g.drawImage(wall, width * j, height * i, this.width, this.height, null);
				}
				if (map[i][j] == 3) {
					g.drawImage(steels, width * j, height * i, this.width, this.height, null);
				}
				if (map[i][j] == 4) {
					g.drawImage(boss, width * j, height * i, this.width, this.height, null);
				}
				if (map[i][j] == 5) {
					this.i = i;
					this.j = j;
					g.drawImage(player, width * j, height * i, height * (j + 1), height * (i + 1), direction*32, direction*32, (direction+1)*32, (direction+1)*32, null);
				}
				if (map[i][j] == 6) {
					this.i = i;
					this.j = j;
					g.drawImage(player, width * j, height * i, height * (j + 1), height * (i + 1), direction*32, direction*32, (direction+1)*32, (direction+1)*32, null);
					g.drawImage(grass, width * j, height * i, this.width, this.height, null);
				}
			}
		}
		for(EnemyTank tank:enemyTanks){
			tank.draw(g);
		}
		for(Bullet b:bullets){
			b.draw(g);
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case 32:
			Bullet b = new Bullet(this.j, this.i, this);
			bullets.add(b);
			b.start();
			break;
			case 37:
				//不在左边界
				if(j>0){
					//判断目标位置是空地还是草
					if(map[i][j-1]==0){
						this.direction = 3;
						//判断自己是在空地上还是在草中
						if(map[i][j]==5){
							//在空地上，目标位置为人
							map[i][j-1] = map[i][j];
							//原位置为空地
							map[i][j] = 0;
						}else if(map[i][j]==6){
							//目标位置为人，原位置为草
							map[i][j-1] = 5;
							map[i][j] = 1;
						}
						//目标是草
					}else if(map[i][j-1]==1){
						this.direction = 3;
						//目标位置为6
						map[i][j-1] = 6;
						//判断原位置为人
						if(map[i][j]==5){
							//原位置设置为空地
							map[i][j] = 0;
							//原位置为人在草中
						}else if(map[i][j]==6){
							//原位置设置为草
							map[i][j] = 1;
						}
					}
				}
				break;
			case 38:
				if(i>0){
					if(map[i-1][j]==0){
						this.direction = 2;
						if(map[i][j]==5){
							map[i-1][j] = map[i][j];
							map[i][j] = 0;
						}else if(map[i][j]==6){
							map[i-1][j] = 5;
							map[i][j] = 1;
						}
					}else if(map[i-1][j]==1){
						this.direction = 2;
						map[i-1][j] = 6;
						if(map[i][j]==5){
							map[i][j] = 0;
						}else if(map[i][j]==6){
							map[i][j] = 1;
						}
					}
				}
				break;
			case 39:
				if(j<map[0].length-1){
					if(map[i][j+1]==0){
						this.direction = 1;
						if(map[i][j]==5){
							map[i][j+1] = map[i][j];
							map[i][j] = 0;
						}else if(map[i][j]==6){
							map[i][j+1] = 5;
							map[i][j] = 1;
						}
					}else if(map[i][j+1]==1){
						this.direction = 1;
						map[i][j+1] = 6;
						if(map[i][j]==5){
							map[i][j] = 0;
						}else if(map[i][j]==6){
							map[i][j] = 1;
						}
					}
				}
				break;
			case 40:
				if(i<map.length-1){
					if(map[i+1][j]==0){
						this.direction = 0;
						if(map[i][j]==5){
						map[i+1][j] = map[i][j];
						map[i][j] = 0;
					}else if(map[i][j]==6){
						map[i+1][j] = 5;
						map[i][j] = 1;
					}
					}else if(map[i+1][j]==1){
						this.direction = 0;
						map[i+1][j] = 6;
						if(map[i][j]==5){
							map[i][j] = 0;
						}else if(map[i][j]==6){
							map[i][j] = 1;
						}
					}
				}
				break;
		}
		this.repaint();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
