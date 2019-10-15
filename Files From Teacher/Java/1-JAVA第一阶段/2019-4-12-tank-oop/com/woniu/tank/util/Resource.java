package com.woniu.tank.util;

import java.awt.Image;

import javax.annotation.Resources;
import javax.swing.ImageIcon;

public class Resource {
	public static Image grass;
	public static Image wall;
	public static Image steel;
	public static Image player;
	public static Image enemy;
	public static Image bullet;
	public static Image boss;
	static{
		grass = new ImageIcon(Resources.class.getResource("/img/grass.png")).getImage();
		wall = new ImageIcon(Resources.class.getResource("/img/wall.gif")).getImage();
		steel = new ImageIcon(Resources.class.getResource("/img/steels.png")).getImage();
		player = new ImageIcon(Resources.class.getResource("/img/player.png")).getImage();
		enemy = new ImageIcon(Resources.class.getResource("/img/enemy.png")).getImage();
		bullet = new ImageIcon(Resources.class.getResource("/img/bullet.png")).getImage();
		boss = new ImageIcon(Resources.class.getResource("/img/boss1.gif")).getImage();
	}
}
