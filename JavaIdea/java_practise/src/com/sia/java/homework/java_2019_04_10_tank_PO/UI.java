package com.sia.java.homework.java_2019_04_10_tank_PO;



import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

public class UI extends JPanel implements KeyListener {

    int[][] points = new int[16][32];
    int i;
    int j;
    private int directionX = 0;
    int directionY = 1;
    private int num;
    private boolean nextIsGrass = false;
    private int count=0;


    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> enemieA = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Bullet> bulletA = new ArrayList<>();
    private ArrayList<Boom> booms = new ArrayList<>();

    private Image background = new ImageIcon( Resources.class.getResource("/img/background.jpg") ).getImage();
    private Image wall = new ImageIcon( Resources.class.getResource("/img/wall.gif") ).getImage();
    private Image grass = new ImageIcon( Resources.class.getResource("/img/grass.png") ).getImage();
    private Image steel = new ImageIcon( Resources.class.getResource("/img/steels.png") ).getImage();
    private Image river = new ImageIcon( Resources.class.getResource("/img/water.gif") ).getImage();
    private Image myBoss = new ImageIcon( Resources.class.getResource("/img/boss1.gif") ).getImage();
    private Image theirBoss = new ImageIcon( Resources.class.getResource("/img/tank.jpg") ).getImage();
    private Image girl =  new ImageIcon( Resources.class.getResource("/img/player.png") ).getImage();

    public UI (){
        Enemy enemy1= new Enemy( 31,0,this );
        Enemy enemy2= new Enemy( 10,0,this );
        enemy1.start();
        enemy2.start();
        enemies.add( enemy1 );
        enemies.add( enemy2 );
        this.setFocusable( true );
        this.addKeyListener( this );
        readMark();
    }
    public void paint( Graphics g ) {
        // 绘制地图
        g.drawImage( background,0,0,1600,750,null);


        // 找到目标
        findTarget( g );
        // 摧毁敌方tank目标
        delEnemyThread();
        // 删除无用子弹线程
        delBulletThread();
        // 删除已经爆炸的线程
        delBoomThread();

        for ( Boom b:booms ) b.draw( g );
        for ( Enemy e: enemies ) e.draw( g );
        drawMap( g );
    }

    private void drawMap( Graphics g ) {
        //墙1 草2 铁3 河4
        for ( int i=0; i<15; i++ ){
            for ( int j=0; j<32; j++ ) {
                switch ( points[i][j] ) {
                    case 1: g.drawImage( wall,50*j,50*i,50*j+50,50*i+50,0,0,50,50,null );
                        break;
                    case 2:
                        g.drawImage( grass,50*j,50*i,50*j+50,50*i+50,0,0,87,83,null );
                        break;
                    case 3: g.drawImage( steel,50*j,50*i,50*j+50,50*i+50,0,0,32,32,null );
                        break;
                    case 4: g.drawImage( river,50*j,50*i,50*j+50,50*i+50,0,0,50,50,null );
                        break;
                    case 5: g.drawImage( myBoss,50*j,50*i,50*j+50,50*i+50,0,0,60,45,null );
                        break;
                    case 6: g.drawImage( theirBoss,50*j,50*i,50*j+50,50*i+50,0,0,156,160,null );
                        break;
                    case 7:
                        g.drawImage( girl,50*j,50*i,50*j+50,50*i+50,this.directionX*32,this.directionY*32,this.directionX*32+32,this.directionY*32+32,null );
                        if ( this.nextIsGrass ){
                            g.drawImage( grass,50*j,50*i,50*j+50,50*i+50,0,0,87,83,null );
                        }
                        this.i = i;
                        this.j = j;
                        break;
                }
            }
        }
    }

    private void findTarget( Graphics g ) {
        for ( Bullet b:bullets ) {
            for ( Enemy e:enemies ){
                if( b.x==e.x && b.y ==e.y ){
                    b.stop();
                    bulletA.add( b );
                    enemieA.add( e );
                    Boom boom = new Boom( e.y,e.x,this);
                    boom.start();
                    booms.add( boom );
                }
            }
            if ( b.x<0 || b.y<0 || b.x>31 || b.y>14 ) {
                b.stop();
                bulletA.add( b );
            }
            else if ( points[b.y][b.x]==1 || points[b.y][b.x]==3 || points[b.y][b.x]==5 || points[b.y][b.x]==6 ){
                b.stop();
                bulletA.add( b );
                Boom boom = new Boom( b.y,b.x,this);
                boom.start();
                booms.add(boom);
                if ( points[b.y][b.x]!=3 ) points[b.y][b.x]=0;
            }
            else b.draw( g );
        }
    }

    private void delBoomThread() {
        while ( true ){
            int count=0;
            for ( Boom b:booms )
                if ( b.getI()>=10 ) {
                    count++;
                    booms.remove(b);
                    break;
                }
            if ( count==0 ) break;
        }
    }

    private void delBulletThread() {
        for ( Bullet a:bulletA ){
            for ( Bullet b:bullets ) {
                if ( a==b ) {
                    bullets.remove(b);
                    break;
                }
            }
        }
        bulletA.clear();
    }

    private void delEnemyThread() {
        for ( Enemy e:enemieA )
            for ( Enemy e1:enemies )
                if ( e==e1 ){
                    enemies.remove(e1);
                    break;
                }
    }

    void readMark() {
        try{
            File file = new File( "D:/mark.txt");
            InputStream in = new FileInputStream( file );
            BufferedReader br = new BufferedReader( new InputStreamReader(in) );
            for ( int i=0; i<15; i++ ){
                String str = br.readLine();
                for ( int j=0; j<32; j++ ) {
                    points[i][j] = Integer.parseInt( String.valueOf( str.charAt(j) ) );
                }
            }
            br.close();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if ( num!=e.getKeyCode() ) this.directionX=0;
        if ( this.directionX ==3 ) this.directionX=0;
        num = e.getKeyCode();
        int temp = points[i][j];
        switch ( e.getKeyCode() ){
            case 32:
                Bullet bullet = new Bullet(this);
                bullet.start();
                bullets.add( bullet );
                break;
            case 37:
                this.directionY = 3;
                if ( j>0 ){
                    if ( points[i][j-1]==0 || points[i][j-1]==2 ){
                        this.nextIsGrass = points[i][j-1] == 2;
                        if ( nextIsGrass ) {
                            points[i][j]=2;
                            count++;
                            if ( count==1 ) points[i][j]=0;
                        }
                        else {
                            points[i][j] = points[i][j-1];
                            if ( count>=1 ) points[i][j] = 2;
                            count=0;
                        }
                        points[i][j-1] = temp;
                    }
                }
                break;
            case 38:
                this.directionY = 2;
                if ( i>0 ){
                    if ( points[i-1][j]==0 || points[i-1][j]==2 ) {
                        this.nextIsGrass = points[i-1][j] == 2;
                        if ( nextIsGrass ){
                            points[i][j]=2;
                            count++;
                            if ( count==1 ) points[i][j]=0;
                        }
                        else{
                            points[i][j] = points[i-1][j];
                            if ( count>=1 ) points[i][j] = 2;
                            count=0;
                        }
                        points[i-1][j] = temp;
                    }
                }
                break;
            case 39:
                this.directionY = 1;
                if ( j<31 ){
                    if ( points[i][j+1]==0 || points[i][j+1]==2) {
                        this.nextIsGrass = points[i][j+1] == 2;
                        if ( nextIsGrass ) {
                            points[i][j]=2;
                            count++;
                            if ( count==1 ) points[i][j]=0;
                        }
                        else {
                            points[i][j] = points[i][j+1];
                            if ( count>=1 ) points[i][j] = 2;
                            count=0;
                        }
                        points[i][j+1] = temp;
                    }
                }
                break;
            case 40:
                this.directionY = 0;
                if ( i<14 ){
                    if ( points[i+1][j]==0 || points[i+1][j]==2 ) {
                        this.nextIsGrass = points[i+1][j] == 2;
                        if ( nextIsGrass ) {
                            points[i][j]=2;
                            count++;
                            if( count==1 ) points[i][j]=0;
                        }
                        else {
                            points[i][j] = points[i+1][j];
                            if ( count>=1 ) points[i][j] = 2;
                            count=0;
                        }
                        points[i+1][j] = temp;
                    }
                }
                break;
        }
        this.directionX++;
        this.repaint();
    }

}
