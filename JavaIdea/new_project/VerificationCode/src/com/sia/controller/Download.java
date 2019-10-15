package com.sia.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download.do")
public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        response.setHeader("content-disposition","attachment;filename="+fileName);
        InputStream is = request.getServletContext().getResourceAsStream("/output/"+fileName);
        ServletOutputStream out = response.getOutputStream();
        IOUtils.copy(is,out);
        File file = new File(request.getServletContext().getRealPath("/output/"+fileName));
        if( file.exists() ) file.delete();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
