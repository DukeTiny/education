package com.sia.java.practise.swing_practise;


import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Note_Open implements ActionListener, KeyListener ,WindowListener{
    private Note note;
    private File file;
    private boolean edited;

    public Note_Open ( Note n ) {
        this.note = n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getActionCommand().equals("Open") ) openFile();
        else if ( ((JMenuItem)e.getSource()).getText().equals("Save") ) saveFile();
        else if ( e.getActionCommand().equals("Save As") ) saveAsFile();
        else if ( e.getActionCommand().equals( "New File")) newFile();
    }

    private void newFile() {
        if ( edited ) System.out.println("File Has Been Saved");
        note.jta.setText("");
        file = null;
    }

    private void saveAsFile() {
        int returnNum = note.jFileChooser.showSaveDialog( note );
        if ( returnNum==0 ) {
            file = note.jFileChooser.getSelectedFile();
            write();
        }
    }

    void saveFile() {
       if( file!=null ) {
           write();
       }
       else saveAsFile();
    }

    void openFile() {
        int returnNum = note.jFileChooser.showOpenDialog( note );
        if ( returnNum==0 ) {
            file = note.jFileChooser.getSelectedFile();
            if ( file!=null ) {
                try{
                    FileReader fr = new FileReader( file );
                    char[] chars = new char[(int) file.length()];
                    fr.read(chars);
                    fr.close();
                    note.jta.setText( new String(chars) );
                }
                catch ( IOException m) {
                    m.printStackTrace();
                }
            }
        }
    }

    void write() {
        try{
            FileWriter fw = new FileWriter(file);
            String str = note.jta.getText();
            fw.write(str);
            fw.flush();
            fw.close();
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        edited = true;
    }




    @Override
    public void windowOpened(WindowEvent e) {

    }




    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Closed");
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");

    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }
}
