package com.sia.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

@WebServlet("/vc.do")
public class VCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> s = request.getParameterNames();
        while (s.hasMoreElements()) System.out.println(s.nextElement());
        BufferedImage image = new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
        Graphics g1 = image.getGraphics();
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setColor(Color.RED);
        g.fillRoundRect(0,0,200,100,0,0);
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuffer sb = new StringBuffer();
        g.setFont(new Font("Helvetica",Font.PLAIN,25));
        g.setColor(Color.WHITE);
        int x = 10;
        Random rand = new Random();
        Integer rotation = null;
        for( int i=0; i<1; i++ ){
            rotation = rand.nextInt()%15;
            g.rotate(60*Math.PI/180,112,38);
            sb.append(chars[rand.nextInt(36)]);
            g.drawString("A",100,50);
//            g.rotate(10,x,25);
            sb.setLength(0);
            x+=20;
        }
        response.setDateHeader("expires", -1);
        //告诉所有浏览器不要缓存
        response.setHeader("Cache-control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        request.getSession().setAttribute("vc",sb.toString());
//        Color color = new Color(220,220,220,128);
//        for( int i=0; i<20; i++ ){
//            g1.setColor(color);
//            g1.drawLine(rand.nextInt(100),0,rand.nextInt(100),50);
//        }
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
