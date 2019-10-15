//package com.sia.java.practise.tank;
//
//import javax.annotation.Resources;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.io.*;
//
//public class UI extends JPanel implements KeyListener {
//
//    private int[][] points = new int[16][32];
//    private int i;
//    private int j;
//    private int directionX = 0;
//    private int directionY = 1;
//    private int num;
//    private boolean nextIsGrass = false;
//    private int count=0;
//
//    public UI (){
//        this.setFocusable( true );
//        this.addKeyListener( this );
//        readMark();
//    }
//    public void paint(Graphics g) {
//        Image background = new ImageIcon( Resources.class.getResource("/img/background.jpg") ).getImage();
//        Image wall = new ImageIcon( Resources.class.getResource("/img/wall.gif") ).getImage();
//        Image grass = new ImageIcon( Resources.class.getResource("/img/grass.png") ).getImage();
//        Image steel = new ImageIcon( Resources.class.getResource("/img/steels.png") ).getImage();
//        Image river = new ImageIcon( Resources.class.getResource("/img/water.gif") ).getImage();
//        Image myBoss = new ImageIcon( Resources.class.getResource("/img/boss1.gif") ).getImage();
//        Image theirBoss = new ImageIcon( Resources.class.getResource("/img/tank.jpg") ).getImage();
//        Image girl =  new ImageIcon( Resources.class.getResource("/img/player.png") ).getImage();
//        g.drawImage( background,0,0,1600,750,null);
//
//        g.drawImage( wall,0,0,50,50,0,0,50,50,null );
//        //墙1 草2 铁3 河4
//        for ( int i=0; i<15; i++ ){
//            for ( int j=0; j<32; j++ ) {
//                switch ( points[i][j] ) {
//                    case 1: g.drawImage( wall,50*j,50*i,50*j+50,50*i+50,0,0,50,50,null );
//                        break;
//                    case 7:
//                        g.drawImage( girl,50*j,50*i,50*j+50,50*i+50,this.directionX*32,this.directionY*32,this.directionX*32+32,this.directionY*32+32,null );
//                        if ( this.nextIsGrass ){
//                            g.drawImage( grass,50*j,50*i,50*j+50,50*i+50,0,0,87,83,null );
//                        }
//                        this.i = i;
//                        this.j = j;
//                        break;
//                    case 2:
//                        g.drawImage( grass,50*j,50*i,50*j+50,50*i+50,0,0,87,83,null );
//                        break;
//                    case 3: g.drawImage( steel,50*j,50*i,50*j+50,50*i+50,0,0,32,32,null );
//                        break;
//                    case 4: g.drawImage( river,50*j,50*i,50*j+50,50*i+50,0,0,50,50,null );
//                        break;
//                    case 5: g.drawImage( myBoss,50*j,50*i,50*j+50,50*i+50,0,0,60,45,null );
//                        break;
//                    case 6: g.drawImage( theirBoss,50*j,50*i,50*j+50,50*i+50,0,0,156,160,null );
//                        break;
//                }
//            }
//        }
//    }
//    void readMark() {
//        try{
//            File file = new File( "D:/mark.txt");
//            InputStream in = new FileInputStream( file );
//            BufferedReader br = new BufferedReader( new InputStreamReader(in) );
//            for ( int i=0; i<15; i++ ){
//                String str = br.readLine();
//                for ( int j=0; j<32; j++ ) {
//                    points[i][j] = Integer.parseInt( String.valueOf( str.charAt(j) ) );
//                }
//            }
//            br.close();
//        }
//        catch ( IOException e ) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        if ( num!=e.getKeyCode() ){
//            this.directionX=0;
//        }
//        if ( this.directionX ==3 ){
//            this.directionX=0;
//        }
//        num = e.getKeyCode();
//        switch ( e.getKeyCode() ){
//            case 37:
//                if ( j>0 ){
//                    if ( points[i][j-1]==0 || points[i][j-1]==2 ){
//                        this.directionY = 3;
//                        this.nextIsGrass = points[i][j - 1] == 2;
//                        if ( nextIsGrass ) {
//                            points[i][j]=2;
//                            count++;
//                            if ( count==1 ) points[i][j]=0;
//                        }
//                        else {
//                            points[i][j] = points[i][j-1];
//                            if ( count>=1 ) points[i][j] = 2;
//                            count=0;
//                        }
//                        points[i][j-1] = 7;
//                    }
//                }
//                break;
//            case 38:
//                if ( i>0 ){
//                    if ( points[i-1][j]==0 || points[i-1][j]==2) {
//                        this.directionY = 2;
//                        this.nextIsGrass = points[i-1][j] == 2;
//                        if ( nextIsGrass ){
//                            points[i][j]=2;
//                            count++;
//                            if ( count==1 ) points[i][j]=0;
//                        }
//                        else{
//                            points[i][j] = points[i-1][j];
//                            if ( count>=1 ) points[i][j] = 2;
//                            count=0;
//                        }
//                        points[i][j-1] = 7;
//                    }
//                }
//                break;
//            case 39:
//                if ( j<31 ){
//                    if ( points[i][j+1]==0 || points[i][j+1]==2) {
//                        this.directionY = 1;
//                        this.nextIsGrass = points[i][j+1] == 2;
//                        if ( nextIsGrass ) {
//                            points[i][j]=2;
//                            count++;
//                            if ( count==1 ) points[i][j]=0;
//                        }
//                        else {
//                            points[i][j] = points[i][j+1];
//                            if ( count>=1 ) points[i][j] = 2;
//                            count=0;
//                        }
//
//                        points[i][j-1] = 7;
//                    }
//                }
//                break;
//            case 40:
//                if ( i<14 ){
//                    if ( points[i+1][j]==0 || points[i+1][j]==2 ) {
//                        this.directionY = 0;
//                        this.nextIsGrass = points[i+1][j] == 2;
//                        if ( nextIsGrass ) {
//                            points[i][j]=2;
//                            count++;
//                            if( count==1 ) points[i][j]=0;
//                        }
//                        else {
//                            points[i][j] = points[i+1][j];
//                            if ( count>=1 ) points[i][j] = 2;
//                            count=0;
//                        }
//                        points[i][j-1] = 7;
//                    }
//                }
//                break;
//        }
//        this.directionX++;
//        this.repaint();
//    }
//
//}
