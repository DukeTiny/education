package com.sia.java.homework.java_2019_04_11_tank_oop.util;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

public class Resource {

    public static Image grass;
    public static Image wall;
    public static Image river;
    public static Image iron;
    public static Image player;
    public static Image enemy;
    public static Image bullet;
    public static Image myBoss;
    public static Image enemyBoss;
    public static Image background;
    public static Image boom;
    public static Image theirBullet;

    static{
        grass = new ImageIcon( Resources.class.getResource("/img/grass.png") ).getImage();
        wall = new ImageIcon( Resources.class.getResource("/img/wall.gif") ).getImage();
        river = new ImageIcon( Resources.class.getResource("/img/water.gif") ).getImage();
        iron = new ImageIcon( Resources.class.getResource("/img/steels.png") ).getImage();
        player = new ImageIcon( Resources.class.getResource("/img/player.png") ).getImage();
        enemy = new ImageIcon( Resources.class.getResource("/img/player2.png") ).getImage();
        bullet = new ImageIcon( Resources.class.getResource("/img/star.png") ).getImage();
        myBoss = new ImageIcon( Resources.class.getResource("/img/bbb.jpg") ).getImage();
        enemyBoss = new ImageIcon( Resources.class.getResource("/img/boss1.gif") ).getImage();
        background = new ImageIcon( Resources.class.getResource("/img/bgbg.jpg") ).getImage();
        boom = new ImageIcon( Resources.class.getResource("/img/boom.png")).getImage();
        theirBullet = new ImageIcon( Resource.class.getResource("/img/bs.png")).getImage();
    }



}
