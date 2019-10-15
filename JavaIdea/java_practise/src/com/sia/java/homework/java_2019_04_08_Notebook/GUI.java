package com.sia.java.homework.java_2019_04_08_Notebook;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JTextField jtB =  new JTextField();
    JLabel labelB = new JLabel("Password");
    JLabel labelA = new JLabel("Username");
    JTextField jtA = new JTextField();
    JButton buttonA = new JButton("Login");
    JButton buttonB = new JButton("Reg");

    public GUI() throws HeadlessException {

        this.setLayout( null );
        labelA.setBounds(70,40,70,20);
        jtA.setBounds(150,40,100,20);

        labelB.setBounds(70,70,70,20);
        jtB.setBounds(150,70,100,20);

        buttonA.setBounds(70,100,85,30);
        buttonA.setBackground( Color.LIGHT_GRAY );
        buttonA.setBorder( null );

        buttonB.setBounds(165,100,85,30);
        buttonB.setBackground( Color.LIGHT_GRAY );
        buttonB.setBorder( null );

        JRadioButton jRadioButtonA = new JRadioButton("Manager" );
        jRadioButtonA.setBounds( 85,140,80,30 );
        JRadioButton jRadioButtonB = new JRadioButton("User",true );
        jRadioButtonB.setBounds( 175,140,120,30 );
        ButtonGroup group = new ButtonGroup();
        group.add( jRadioButtonA );
        group.add( jRadioButtonB );
        this.add( jRadioButtonA );
        this.add( jRadioButtonB );
        this.add( labelA );
        this.add( jtA );
        this.add( labelB );
        this.add( jtB );
        this.add( buttonA );
        this.add( buttonB );


        this.setSize(350,240);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
