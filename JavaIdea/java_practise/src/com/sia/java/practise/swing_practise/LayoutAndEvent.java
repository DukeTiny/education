package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutAndEvent extends JFrame {
        JTextField jtB =  new JTextField();
        JLabel labelB = new JLabel("Password");
        JLabel labelA = new JLabel("Username");
        JTextField jtA = new JTextField();
        JButton buttonA = new JButton("Login");
        JButton buttonB = new JButton("Reg");

    public LayoutAndEvent() throws HeadlessException {

//        buttonB.addActionListener( new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jtB.setSize(150,20);
//            }
//        });

        this.setLayout( null );
        labelA.setBounds(70,50,70,20);
        jtA.setBounds(150,50,100,20);

        labelB.setBounds(70,80,70,20);
        jtB.setBounds(150,80,100,20);

        buttonA.setBounds(70,110,85,30);

        buttonB.setBounds(165,110,85,30);
        buttonB.setBackground(Color.ORANGE);
        buttonB.setBorder(null);
        this.add( labelA );
        this.add( jtA );
        this.add( labelB );
        this.add( jtB );
        this.add( buttonA );
        this.add( buttonB );

        class Event implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtB.setSize(150,20);
            }
        }
        Event e = new Event();
        buttonB.addActionListener( e );

        this.setSize(350,240);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }

    public static void main(String[] args)  {
        LayoutAndEvent p15 = new LayoutAndEvent();
    }
}

//class Event implements ActionListener {
//    private LayoutAndEvent p15;
//    public Event(){
//    }
//
//    public Event( LayoutAndEvent p15 ){
//        this.p15 = p15;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        p15.jtB.setSize(150,20);
//    }
//}
