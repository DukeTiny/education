package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;

public class FlowoutPrac {


    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();

        jp.add( new Button("1") );
        jp.add( new Button("2") );
        jp.add( new Button("3") );
        jp.add( new Button("4") );
        jp.add( new Button("5") );
        jp.add( new Button("6") );
        jp.add( new Button("7") );
        jp.add( new Button("8") );

        jp.setLayout( new FlowLayout(0,50,50) );
        jp.setBackground( Color.getHSBColor(0,0,5) );
        jf.add( jp );
        jf.setVisible( true );
        jf.setBounds( 500,300,500,500 );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }


}
