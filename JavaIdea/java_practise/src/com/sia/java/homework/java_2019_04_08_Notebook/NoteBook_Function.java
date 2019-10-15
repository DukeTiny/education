package com.sia.java.homework.java_2019_04_08_Notebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NoteBook_Function implements ActionListener {

    private com.sia.java.homework.java_2019_04_08_Notebook.NoteBook noteBook;
    private boolean selectAll;


    public NoteBook_Function( NoteBook note ) {
        this.noteBook = note;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getActionCommand().equalsIgnoreCase("Open File" ) ){
            int choice = noteBook.jFileChooser.showOpenDialog( noteBook.jFrame );
            if ( choice==0 ) {
                File file = noteBook.jFileChooser.getSelectedFile();
                try {
                    FileReader fr = new FileReader( file );
                    char[] chars = new char[ (int)file.length() ];
                    fr.read( chars);
                    fr.close();
                    noteBook.jTextArea.setText( new String(chars) );
                } catch ( IOException e1 ) {
                    e1.printStackTrace();
                }
            }

        }
        else if ( e.getActionCommand().equalsIgnoreCase("Copy" ) ){
            noteBook.jTextArea.copy();
        }
        else if ( e.getActionCommand().equalsIgnoreCase("Paste" ) ){
            noteBook.jTextArea.paste();
        }
        else if ( e.getActionCommand().equalsIgnoreCase("Cut" ) ){
            noteBook.jTextArea.cut();
        }
        else if ( e.getActionCommand().equalsIgnoreCase("Select All" ) ){
            noteBook.jTextArea.selectAll();
            selectAll = true;
        }
        else if ( e.getActionCommand().equalsIgnoreCase("Cancel All" ) ){
            if ( selectAll ){
//                noteBook.jTextArea.copy();
//                noteBook.jTextArea.paste();
                noteBook.jTextArea.setCaretPosition( noteBook.jTextArea.getCaretPosition() );
                noteBook.jTextArea.append("");
                selectAll = false;
            }
        }
        else if ( e.getActionCommand().equalsIgnoreCase("Auto Change" ) ){
            noteBook.jTextArea.setLineWrap( !noteBook.jTextArea.getLineWrap() );
        }

    }
}
