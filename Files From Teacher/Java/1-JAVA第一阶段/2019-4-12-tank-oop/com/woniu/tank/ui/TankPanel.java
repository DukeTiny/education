package com.woniu.tank.ui;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import com.woniu.tank.bean.EnemyTank;
import com.woniu.tank.bean.Player;
import com.woniu.tank.bean.Wall;
import com.woniu.tank.controll.Controller;
import com.woniu.tank.util.Map;

public class TankPanel extends JPanel {
	public static int[][] level;
	Player p1;
	int i;
	int j;
	Vector<EnemyTank> enemyTanks = new Vector<EnemyTank>();
	public TankPanel(){
		level = Map.map1;
		p1 = new Player(this,7,14);
		EnemyTank enemy = new EnemyTank(this, 0, 0);
		EnemyTank enemy2 = new EnemyTank(this, 14,0);
		enemy.setWidth(40);
		enemy.setHeight(40);
		enemy2.setWidth(40);
		enemy2.setHeight(40);
		enemyTanks.add(enemy);
		enemyTanks.add(enemy2);
		
		this.setFocusable(true);
		this.addKeyListener(new Controller(p1));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		p1.setWidth(40);
		p1.setHeight(40);
		p1.draw(g);
		
		for(EnemyTank et:enemyTanks){
			et.draw(g);
		}
		
		for(int i=0;i<level.length;i++){
			for(int j=0;j<level[i].length;j++){
				if(level[i][j]>=1&&level[i][j]<=4){
					Wall w = new Wall(level[i][j]);
					w.setX(j);
					w.setY(i);
					w.setWidth(40);
					w.setHeight(40);
					w.draw(g);
				}
				
			}
		}
		
		
	}

}
