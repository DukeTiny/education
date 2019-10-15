package com.woniu.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.annotation.Resources;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
					{ 0, 0, 0, 0, 0, 0, 0, -1, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0 }
				};
	int width = 40;
	int height = 40;
	
	int i;
	int j;
	
	int direction = 2; //0об 1ср 2ио 3вС	00 32 32
	
	public TankPanel() {
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	
	
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
				if (map[i][j] == -1) {
					this.i = i;
					this.j = j;
					g.drawImage(player, width * j, height * i, height * (j + 1), height * (i + 1), this.direction*32, this.direction*32, (this.direction+1)*32, (this.direction+1)*32, null);
				}
			}
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
			case 37:
				this.direction = 3;
				int temp = map[i][j];
				map[i][j] = map[i][j-1];
				map[i][j-1] = temp;
				break;
			case 38:
				this.direction = 2;
				temp = map[i][j];
				map[i][j] = map[i-1][j];
				map[i-1][j] = temp;
				break;
			case 39:
				this.direction = 1;
				temp = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = temp;
				break;
			case 40:
				this.direction = 0;
				temp = map[i][j];
				map[i][j] = map[i+1][j];
				map[i+1][j] = temp;
				break;
		}
		this.repaint();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
