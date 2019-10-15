package com.sia.java.practise.graphic_practise;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Draw extends JFrame implements MouseListener {

    ArrayList<Chess> chesses = new ArrayList<>();
    Color c = Color.BLACK;
    public Draw() {
        this.setSize( 900,900);
        this.setLocationRelativeTo( null );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.addMouseListener( this );
    }

    @Override
    public void paint( Graphics g ){
        g.setColor( new Color(79, 79, 79) );
        g.fillRect( 0,0,this.getWidth(),this.getHeight() );
        g.setColor( new Color( 200,200,200));
//        Image image = new ImageIcon( "C:/Users/Administrator/Desktop/img/img/player.png" ).getImage();
        Image image = new ImageIcon( Resources.class.getResource("/img/player.png") ).getImage();
        g.drawImage(image,50,50,200,200,0,0,32,32,null);
        for ( int i=1; i<18; i++ ){
            g.drawLine(50*i,50,50*i,850);
            g.drawLine(50,50*i,850,50*i);
        }

        for ( int i=0; i<chesses.size(); i++ ) {
            g.setColor( chesses.get(i).getColor() );
            g.fillOval( chesses.get(i).getX(),chesses.get(i).getY(),40,40 );
        }


    }

    public static void main(String[] args) {
        new Draw();
//        System.out.println( Resources.class.getResource("bg/jpg") );

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0;
        int y = 0;
        x = (e.getX()-25)/50*50 +25;
        y = (e.getY()-25)/50*50 +25;
        boolean repeat = false;

        if ( chesses.size()!=0 ) {
            for ( Chess c : chesses ){
                if ( x == c.getX() && y == c.getY() ){
                    repeat = true;
                }
            }
        }

        if ( !repeat && x>=25 && x<=825 &&  y>=25 && y<=825 ){
            Chess chess = new Chess();
            chess.setX( x );
            chess.setY( y );
            chess.setColor( c );
            if ( c==Color.BLACK ){
                c = Color.white;
            }
            else c = Color.BLACK;
            chesses.add( chess );
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
