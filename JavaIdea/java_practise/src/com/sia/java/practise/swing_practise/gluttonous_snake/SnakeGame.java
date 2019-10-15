package com.sia.java.practise.swing_practise.gluttonous_snake;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SnakeGame implements KeyListener {
    private JFrame jFrame = new JFrame( "Gluttonous Snake" );
    private JButton head = new JButton();
    private JButton food = new JButton();
    private int direction = 39;
    private Timer timer;
    private Timer keyTimer;
    private boolean isStart = false;
    private ArrayList<JButton> al = new ArrayList<JButton>();
    private int speed = 400;
    private boolean canClick = true;

    public static void main(String[] args) {
        new SnakeGame().run();
    }


    void run() {
        head.setSize(50,50);
        head.setBackground( new Color( 255,0,0) );
        al.add(head);

        getFood();

        head.addKeyListener( this );
        startGame();

        jFrame.add( food );
        jFrame.add( head );
        jFrame.setLayout( null );
        jFrame.setSize(617,637);
        jFrame.setLocationRelativeTo( null );
        jFrame.setVisible( true );
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    }

    void eat() {
        if ( head.getX()==food.getX() && head.getY()==food.getY() ){
            getFood();
            grow();
        }
    }

    void follow() {
        for ( int i=al.size()-1; i>0; i-- ) {
            al.get(i).setLocation( al.get(i-1).getX(),al.get(i-1).getY() );
        }
    }

    private void grow() {
        if ( al.size()<3 ) {
            JButton newButton = new JButton();
            newButton.setBackground( Color.orange );
            newButton.setSize( head.getWidth(), head.getHeight() );
            newButton.setLocation( head.getX(), head.getY() );
            jFrame.add( newButton );
            al.add( newButton );
        }
        else {
            speed /=2;
            restartGame();
            startGame();
        }
    }

    void getFood() {
        int x = (int)( Math.random()*12 )*50;
        int y = (int)( Math.random()*12 )*50;
        food.setBackground( Color.GREEN );
        food.setSize(50,50);
        for ( int i=0; i<al.size(); i++ ){
            if ( x==al.get(i).getX() && y==al.get(i).getY())
                getFood();
        }
        food.setLocation( x,y );
    }

    void restartGame() {
        timer.stop();
        keyTimer.stop();
        timer = null;
        keyTimer = null;
        for ( int i=1; i<al.size();  ){
            jFrame.remove( al.get(i) );
            al.remove( al.get(i) );
        }
        head.setLocation(0,0);
        isStart = false;
        direction = 39;
    }

    void startGame() {
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !isStart ){
                    isStart = true;
                    keyTimer = new Timer(speed, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            follow();
                            int x = head.getX();
                            int y = head.getY();
                            switch (direction) {
                                case 37:
                                    if ( x==0 ) x=600;
                                    x -= head.getWidth();
                                    break;
                                case 38:
                                    if ( y==0 ) y=600;
                                    y-=head.getHeight();
                                    break;
                                case 39:
                                    if ( x==600 ) x=-50;
                                    x += head.getWidth();
                                    break;
                                case 40:
                                    if ( y==600 ) y=-50;
                                    y += head.getHeight();
                                    break;
                            }
                            canClick = true;
                            head.setLocation(x,y);
                        }
                    });
                }
                keyTimer.start();
                eat();
            }
        });
        timer.start();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if( e.getKeyCode()==10 ){
            if ( timer.isRunning() ) {
                timer.stop();
                keyTimer.stop();
            }
            else if( !timer.isRunning() ) {
                timer.restart();
                keyTimer.restart();
            }
        }
        if ( e.getKeyCode()==116 ){
            restartGame();
            startGame();
        }
        if ( canClick && Math.abs( e.getKeyCode()-direction ) !=2 && ( e.getKeyCode()==37 || e.getKeyCode()==38 || e.getKeyCode()==39 || e.getKeyCode()==40) ){
            canClick = false;
            direction = e.getKeyCode();
        }
    }
}
