package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutPrac {


    public static void makeButton(String title,JPanel jpanel,GridBagLayout gridBagLayout,GridBagConstraints constraints) {
        Button button = new Button( title );    //创建Button对象
        button.setFont( new Font( "微软雅黑",Font.PLAIN,22));
        gridBagLayout.setConstraints( button,constraints );
        jpanel.add( button );
        button.setBackground( Color.yellow );
    }
    public static void main(String[] agrs) {
        JFrame frame = new JFrame( "拨号盘" );
        JPanel jp = new JPanel();
        JPanel jp1 = new JPanel();
        GridBagLayout gbaglayout = new GridBagLayout();    //创建GridBagLayout布局管理器
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill=GridBagConstraints.BOTH;    //组件填充显示区域
        constraints.weightx=0.0;    //恢复默认值
        constraints.weighty=0.15;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;    //结束行
        JTextField tf = new JTextField( "13612345678" );
        tf.setFont( new Font( "微软雅黑",Font.PLAIN,22 ) );
        gbaglayout.setConstraints( tf, constraints );
        jp.setLayout( gbaglayout);    //使用GridBagLayout布局管理器
        jp1.setLayout( gbaglayout );    //使用GridBagLayout布局管理器
        jp.add( tf );
        frame.setLayout( new GridLayout(2,1) );
        frame.add( jp );
        frame.add( jp1 );
        constraints.weightx=0.33;    // 指定组件的分配区域
        constraints.weighty=0.4;
        constraints.gridwidth = 1;
        makeButton( "7",jp,gbaglayout,constraints );    //调用方法，添加按钮组件
        makeButton( "8",jp,gbaglayout,constraints );
        constraints.gridwidth=GridBagConstraints.REMAINDER;    //结束行
        makeButton( "9",jp,gbaglayout,constraints );
        constraints.gridwidth=1;    //重新设置gridwidth的值

        makeButton("4",jp,gbaglayout,constraints);
        makeButton("5",jp,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("6",jp,gbaglayout,constraints);
        constraints.gridwidth=1;

        makeButton("1",jp,gbaglayout,constraints);
        makeButton("2",jp,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("3",jp,gbaglayout,constraints);
        constraints.gridwidth=1;

        makeButton("Back",jp1,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("Dial",jp1,gbaglayout,constraints);
        constraints.gridwidth=1;
        frame.setBounds(400,400,400,400);    //设置容器大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
