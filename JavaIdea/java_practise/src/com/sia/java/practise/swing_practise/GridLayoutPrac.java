package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;

public class GridLayoutPrac {

    public static void main(String[] args) {
        JFrame jf = new JFrame(  "网格布局管理器之傻屌计算器" );
        JPanel jp = new JPanel( new GridLayout(4,4,5,5));
        Font font = new Font("微软雅黑",Font.PLAIN,21);
        jp.setFont ( font );
        jp.setBackground( Color.DARK_GRAY );
        jp.add( new Button("7") );
        jp.add( new Button("8") );
        jp.add( new Button("9") );
        jp.add( new Button("/") );
        jp.add( new Button("4") );
        jp.add( new Button("5") );
        jp.add( new Button("6") );
        jp.add( new Button("*") );
        jp.add( new Button("1") );
        jp.add( new Button("2") );
        jp.add( new Button("3") );
        jp.add( new Button("-") );
        jp.add( new Button("0") );
        jp.add( new Button(".") );
        jp.add( new Button("=") );
        jp.add( new Button("+") );
        jf.add( jp );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jf.setVisible( true );
        jf.setBounds( 150,150,400,300);

    }


}
