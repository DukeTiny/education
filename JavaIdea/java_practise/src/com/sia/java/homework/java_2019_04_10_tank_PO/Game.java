package com.sia.java.homework.java_2019_04_10_tank_PO;

import javax.swing.*;

public class Game extends JFrame {
    UI ui = new UI();
    public Game () {
        this.setContentPane( ui );
        this.setSize(1617,788);
        this.setLocationRelativeTo( null );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}
