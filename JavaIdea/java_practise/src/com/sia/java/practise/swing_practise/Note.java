package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Note extends JFrame {
    JMenuBar jm = new JMenuBar();
    JMenu jMenu = new JMenu("File");
    JMenuItem jmiA = new JMenuItem("New File");
    JMenuItem jmiB = new JMenuItem("Open");
    JMenuItem jmiC = new JMenuItem("Create");
    JMenuItem jmiD = new JMenuItem("Save");
    JMenuItem jmiE = new JMenuItem("Save As");
    JMenuItem jmiF = new JMenuItem("Exit");
    JTextArea jta = new JTextArea();
    JScrollPane jsp;

    JFileChooser jFileChooser = new JFileChooser();

    public Note() {
        jMenu.add( jmiA );
        jMenu.add( jmiB );
        jMenu.add( jmiC );
        jMenu.add( jmiD );
        jMenu.add( jmiE );
        jMenu.add( jmiF );
        Font font = new Font("微软雅黑",Font.PLAIN,16);
        jMenu.setFont(font);
        jMenu.setBackground(Color.white);
        jMenu.setBorder(null);
        jm.add( jMenu );
        jsp = new JScrollPane( jta );
//        jta.setSize(500,500);
        Dimension size = jta.getPreferredSize();
        jsp.setBounds(10,10,size.width,size.height);

        this.setTitle("Note");
        this.setJMenuBar( jm );
        this.add( jsp );

        Note_Open no = new Note_Open( this );
        jmiB.addActionListener( no );
        jmiD.addActionListener( no );
        jmiE.addActionListener( no );
        jta.addKeyListener( no );
        jmiA.addActionListener( no );
        this.addWindowListener( no );

        this.setSize(550,300);
        this.setLocationRelativeTo( null );
        this.setVisible(true);
        this.setDefaultCloseOperation( 0 );
    }

    public static void main(String[] args) {
        Note note = new Note();
    }
}
