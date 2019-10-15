package com.woniu.gui;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame {
	JMenuBar menubar = new JMenuBar();
	JMenu fileMenu = new JMenu("file");
	JMenuItem newItem = new JMenuItem("new");
	JMenuItem openItem = new JMenuItem("open");
	JMenuItem saveItem = new JMenuItem("save");
	JMenuItem saveAsItem = new JMenuItem("save as");
	JMenuItem exitItem = new JMenuItem("exit");
	JTextArea ta = new JTextArea();
	JScrollPane jsp = new JScrollPane(ta);
	JFileChooser fileChooser = new JFileChooser();
	JOptionPane op = new JOptionPane();
	public Notepad(){
		//给菜单加菜单项
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(exitItem);
		//给菜单条加菜单
		menubar.add(fileMenu);
		//给JFrame加菜单条
		this.setJMenuBar(menubar);
		
		//使用事件处理
		NotepadListener nl = new NotepadListener(this);
		openItem.addActionListener(nl);
		saveItem.addActionListener(nl);
		saveAsItem.addActionListener(nl);
		newItem.addActionListener(nl);
		
		ta.addKeyListener(nl);
		
		this.addWindowListener(nl);
		
		//给Jframe添加带滚动条的文本域
		this.add(jsp);
		
		
		this.setSize(600,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(0);
	}
	public static void main(String[] args) {
		new Notepad();
	}
}
