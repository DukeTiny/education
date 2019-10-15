package com.woniu.socket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener {

	JTextArea ta = new JTextArea();
	JScrollPane jsp = new JScrollPane(ta);
	
	JTextField message = new JTextField(10);
	
	JButton send = new JButton("send");
	
	JPanel sendPanel = new JPanel();
	
	
	Socket s;
	
	OutputStream out;
	
	BufferedReader br;
	
	PrintWriter pw;
	
	InputStream in;
	
	public ClientFrame() throws IOException{
		this.setTitle("客户端");
		
		sendPanel.add(message);
		sendPanel.add(send);
		
		this.add(jsp,BorderLayout.CENTER);
		
		this.add(sendPanel,BorderLayout.SOUTH);
		
		send.addActionListener(this);
		
		this.setSize(300,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		
		s = new Socket("192.168.7.221", 10101);
		out = s.getOutputStream();
		in = s.getInputStream();
		br = new BufferedReader(new InputStreamReader(in));
		pw = new PrintWriter(out);
		while(true){
			while(br.ready()){
				String words = br.readLine();
				ta.append("服务器端说:"+words+"\n");
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String myWords = message.getText();
		ta.append("我说:"+myWords+"\n");
		pw.println(myWords);
		pw.flush();
	}

	public static void main(String[] args) throws IOException {
		new ClientFrame();
	}
}
