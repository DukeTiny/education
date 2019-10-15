package com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame;


import com.sia.java.homework.java_2019_04_11_tank_oop.bean.*;
import com.sia.java.homework.java_2019_04_11_tank_oop.controller.PlayerController;
import com.sia.java.homework.java_2019_04_11_tank_oop.util.Map;
import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UI extends JPanel {

    public int[][] level;
    private Player p;
    private int enemyNum = 1;
    private int index = 0;
    private boolean canLevelUp = false;
    public Map map = new Map();


    public Vector<Bullet> bullets = new Vector<>();
    public Vector<Boom> booms = new Vector<>();
    public Vector<Enemy> enemies = new Vector<>();
    public final Vector<TheirBullet> theirBullets = new Vector<>();

    public UI() {
        level = (int[][])map.getObj()[index];
        p = new Player( this,6,8 );
        this.setFocusable( true );
        this.addKeyListener( new PlayerController( p ) );
    }

    @Override
    public void paint( Graphics g ){
        createEnemies();
        levelUp();
        removeEnemies();
        drawPic(g);
    }
    // 随机产生敌人
    private void createEnemies() {
        if( enemies.size()<1 ) {
            if (enemyNum <= 3) {
                int x = (int) (Math.random() * 17);
                int y = (int) (Math.random() * 9);
                if (x != p.getX() && y != p.getY() && level[y][x] < 2) {
                    Enemy enemy = new Enemy(this, x, y);
                    enemies.add(enemy);
                    enemyNum++;
                } else createEnemies();
            } else if (enemyNum == 4) {
                for ( TheirBullet t:theirBullets ){
                    t.setCanDo( false );
                }
                this.canLevelUp = true;
            }
        }
    }
    //删除掉敌人
    private void removeEnemies(){
        while ( true ){
            int count = 0;
            for( Enemy e:enemies ) {
                if ( !e.alive ){
                    count++;
                    enemies.remove( e );
                    break;
                }
            }
            if( count==0 ) break;
        }
    }
    // 面板内容
    private void drawPic( Graphics g ) {
        g.drawImage( Resource.background,0,0,850,450,null);
        for ( Bullet b:bullets ) b.draw( g );
        p.draw(g);
        for ( TheirBullet t:theirBullets ) t.draw( g );
        for( Enemy e:enemies ) e.draw( g );
        for ( int i=0; i<level.length; i++ ) {
            for ( int j=0; j<level[i].length; j++ ){
                Block block = new Block( level[i][j] );
                block.setX( j );
                block.setY( i );
                block.draw( g );
            }
        }
        for ( Boom b:booms ) b.draw( g );
    }

    // 下一关
    private void levelUp() {
        if ( canLevelUp || !map.isEnemyBossIsAlive() ) {
            index++;
            level = (int[][])map.getObj()[index];
            for( Bullet b:bullets ) b.getT().stop();
            bullets.clear();
            for( Enemy e:enemies ) e.getT().stop();
            booms.clear();
            theirBullets.clear();
            p.setX( 6 );
            p.setY( 8 );
            p.setDirectionY( 0 );
            enemyNum = 0;
            map.setEnemyBossIsAlive( true );
            this.canLevelUp = false;
        }

    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }
}
