package com.sia.java.practise.net_practise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {

    ServerSocket ss;

    Socket s;

    JFrame jFrame;

    JTextArea jTextArea;

    JScrollPane jsp;

    JScrollPane jspA;

    JButton jButton;

    JTextArea jtf;

    JPanel jPanel;

    OutputStream out;

    InputStream in;

    PrintWriter pr;

    BufferedWriter bw;

    BufferedReader br;


    public static void main(String[] args) throws IOException {
        new Client().ui();
    }



    public void ui () throws IOException {

        jPanel = new JPanel();
        jFrame = new JFrame();
        jTextArea = new JTextArea();
        jsp = new JScrollPane(jTextArea);

        jButton = new JButton("发送");
        jButton.setBackground(Color.green);
        jButton.setFont(new Font("楷体", Font.PLAIN, 18));
        jTextArea.setFont(new Font("楷体", Font.PLAIN, 18));
        jtf = new JTextArea(2, 41);
        jtf.setFont(new Font("楷体", Font.PLAIN, 18));
        jspA = new JScrollPane(jtf);

        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jFrame.add(jsp, BorderLayout.CENTER);
        jPanel.add(jspA);
        jPanel.add(jButton);
        jFrame.add(jPanel, BorderLayout.SOUTH);

        jFrame.setSize(480, 350);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jButton.addActionListener( this );
        s = new Socket("192.168.9.166", 110);
        out = s.getOutputStream();
        in = s.getInputStream();
        br = new BufferedReader( new InputStreamReader( in ) );
        pr = new PrintWriter( new OutputStreamWriter( out) );
//        bw = new BufferedWriter( new OutputStreamWriter( out) );
        while ( true ){
            while ( br.ready() ) {
                String str = br.readLine();
                jTextArea.append( "客户端说：" + str + "\r\n");
            }
        }
    }
    void send() {
        String str = jtf.getText();
        jTextArea.append("我说:" + str + "\r\n");
        pr.println(str);
        pr.flush();
        pr.close();
    }
//    void send() throws IOException {
//        String str = jtf.getText();
//        jTextArea.append("我说:" + str + "\r\n");
//        bw.write(str);
//        bw.flush();
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        try {
//            send();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        send();
    }

}
