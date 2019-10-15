package com.sia.java.practise.swing_practise;

import javax.swing.*;
import java.awt.*;
public class JFrameDemo extends JFrame {
    public JFrameDemo()
    {
        setTitle("Java 第一个 GUI 程序");    //设置显示窗口标题
        setSize(400,200);    //设置窗口显示尺寸
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
        JLabel jl = new JLabel("这是使用JFrame类创建的窗口");    //创建一个标签
        Container c = getContentPane();    //获取当前窗口的内容窗格
        c.add(jl);    //将标签组件添加到内容窗格上
        setVisible(true);    //设置窗口是否可见
    }
    public static void main(String[] agrs) {
        new JFrameDemo();    //创建一个实例化对象
        JFrame frame = new JFrame();
        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setTitle("This is a test");
        Container c = frame.getContentPane();
        c.add( BorderLayout.WEST,new JLabel("i don't know"));
        c.add( BorderLayout.EAST,new Button("Comfirm") );
        JPanel jp = new JPanel();
        Button b = new Button("aaa");
        Font bigFont = new Font("微软雅黑",Font.BOLD,30);
        b.setFont(bigFont);
        c.add(BorderLayout.NORTH,b);
    }
}
