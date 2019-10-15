package com.sia.java.homework.java_2019_04_11_tank_oop.controller;

import com.sia.java.homework.java_2019_04_11_tank_oop.bean.Bullet;
import com.sia.java.homework.java_2019_04_11_tank_oop.bean.Player;
import com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame.UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private Player p;
    private int num;
    private UI ui;
    public PlayerController ( Player p ){
        this.p = p;
        this.ui = p.getUi();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if( p.isAlive() ) {
            if (num != e.getKeyCode()) p.setDirectionX(0);
            if (p.getDirectionX() == 3) p.setDirectionX(0);
            num = e.getKeyCode();
            int x = p.getX();
            int y = p.getY();
            switch (e.getKeyCode()) {
                case 32:
                    Bullet bullet = new Bullet(p);
                    p.getUi().bullets.add(bullet);
                    break;
                case 37:
                    p.setDirectionY(3);
                    if (x > 0) {
                        if (ui.level[y][x - 1] < 2) p.setX(x - 1);
                    }
                    break;
                case 38:
                    p.setDirectionY(2);
                    if (y > 0) {
                        if (ui.level[y - 1][x] < 2) p.setY(y - 1);
                    }
                    break;
                case 39:
                    p.setDirectionY(1);
                    if (x < 16) {
                        if (ui.level[y][x + 1] < 2) p.setX(x + 1);
                    }
                    break;
                case 40:
                    p.setDirectionY(0);
                    if (y < 8) {
                        if (ui.level[y + 1][x] < 2) p.setY(y + 1);
                    }
                    break;
            }
            p.setDirectionX(p.getDirectionX() + 1);
            p.getUi().repaint();
        }
    }
}
