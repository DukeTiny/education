package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;

public class TrySwing {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();
        panelA.setSize(400,200);
        panelB.setSize(200,200);
        panelA.setBackground(Color.gray);
        panelB.setBackground(Color.darkGray);
//        panelA.add(BorderLayout.WEST,panelB);
//        panelA.setVisible(true);
//        panelB.setVisible(true);
        panelA.setLayout( new BoxLayout(panelA,BoxLayout.Y_AXIS));
        panelA.add(new Button("ABC000000000"));
        panelA.add(new Button("000"));
        frame.getContentPane().add(BorderLayout.WEST,panelA);
        frame.getContentPane().add(BorderLayout.EAST,panelB);
        frame.setSize(250,200);
        frame.setVisible(true);

    }

}
