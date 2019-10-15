package com.woniu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class NotepadListener implements ActionListener,KeyListener,WindowListener {
	Notepad note;
	File file;
	FileReader fr;
	FileWriter fw;
	boolean isEdited;
	
	public NotepadListener(Notepad n) {
		this.note = n;
	}

	public void actionPerformed(ActionEvent e) {
		// e.getActionCommand(); //获得事件源上的文字
		// e.getSource(); //获得事件源对象
		if (e.getActionCommand().equals("open")) {
			openFile();
		} else if (e.getActionCommand().equals("save")) {
			saveFile();
		} else if (e.getActionCommand().equals("save as")) {
			saveAsFile();
		} else if (e.getActionCommand().equals("new")) {
			newFile();
		}
	}

	private void newFile() {
		if(isEdited){
			int s = note.op.showConfirmDialog(note, "文件已修改，是否保存？");
			if(s==0){
				saveFile();
				note.ta.setText("");
				file = null;
			}else if(s==1){
				note.ta.setText("");
				file = null;
				isEdited = false;
			}
		}
		
	}

	private void saveAsFile() {
		int select = note.fileChooser.showSaveDialog(note);
		if (select == 0) {
			file = note.fileChooser.getSelectedFile();
			try {
				fw = new FileWriter(file);
				String str = note.ta.getText();
				fw.write(str);
				fw.close();
				isEdited = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void saveFile() {
		if (file != null) {
			try {
				fw = new FileWriter(file);
				String str = note.ta.getText();
				fw.write(str);
				fw.close();
				isEdited = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			saveAsFile();
		}
	}

	public void openFile() {
		// 弹出打开文件对话框
		int select = note.fileChooser.showOpenDialog(note);
		if (select == 0) {
			file = note.fileChooser.getSelectedFile();
			if (file != null) {
				try {
					fr = new FileReader(file);
					char[] cs = new char[(int) file.length()];
					fr.read(cs);
					fr.close();
					String str = new String(cs).trim();
					note.ta.setText(str);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped...");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed...");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isEdited = true;
		System.out.println("keyReleased..."+isEdited);
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("windowOpened...");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing...");
		int s =note.op.showConfirmDialog(note, "文件已修改，是否保存？");
		if(s>=0&&s<=1){
			if(s==0){
				saveFile();	
			}
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed...");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified...");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified...");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated...");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("windowDeactivated...");
	}

}
