package com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame;

import javax.swing.*;

public class GameFrame extends JFrame {

    private UI ui = new UI();

    public GameFrame(){
        this.setContentPane( ui );
        this.setSize( 867,487 );
        this.setLocationRelativeTo ( null );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }


}
