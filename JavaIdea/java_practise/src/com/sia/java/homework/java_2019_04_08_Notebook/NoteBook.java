package com.sia.java.homework.java_2019_04_08_Notebook;

import javax.swing.*;

public class NoteBook {

        JFrame jFrame = new JFrame("NoteBook");
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuA = new JMenu("File");
        JMenu jMenuB = new JMenu("Edit");
        JMenuItem openItem = new JMenuItem( "Open File" );
        JMenuItem copyItem = new JMenuItem( "Copy" );
        JMenuItem pasteItem = new JMenuItem( "Paste" );
        JMenuItem cutItem = new JMenuItem( "Cut" );
        JMenuItem nextRowItem = new JMenuItem( "Auto Change" );
        JMenuItem sAItem = new JMenuItem( "Select All" );
        JMenuItem cancelSAItem = new JMenuItem( "Cancel All" );
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollpane = new JScrollPane( jTextArea );
        JFileChooser jFileChooser = new JFileChooser();

    public static void main(String[] args) {
        NoteBook no = new NoteBook();
        no.run();
    }


    void run() {
        jMenuA.add( openItem );
        jMenuB.add( copyItem );
        jMenuB.add( pasteItem );
        jMenuB.add( cutItem );
        jMenuB.add( sAItem );
        jMenuB.add( nextRowItem );
        jMenuB.add( cancelSAItem );

        jTextArea.setWrapStyleWord( true );
        jMenuBar.add( jMenuA );
        jMenuBar.add( jMenuB );
        jFrame.setJMenuBar( jMenuBar );
        jFrame.add( jScrollpane );

        NoteBook_Function nf = new NoteBook_Function( this );
        openItem.addActionListener( nf );
        copyItem.addActionListener( nf );
        pasteItem.addActionListener( nf );
        cutItem.addActionListener( nf );
        sAItem.addActionListener( nf );
        nextRowItem.addActionListener( nf );
        cancelSAItem.addActionListener( nf );

            jFrame.setSize(320,180);
            jFrame.setLocationRelativeTo( null );
            jFrame.setVisible( true );
            jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}
