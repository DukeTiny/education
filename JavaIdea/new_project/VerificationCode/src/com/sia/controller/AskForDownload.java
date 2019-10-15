package com.sia.controller;

import com.sia.bean.Dept;
import com.sia.dao.DaoFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@WebServlet("/askForDownload.do")
public class AskForDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "askForDownload":
                readAndWrite(request,response);
                break;
        }
    }

    private void readAndWrite(HttpServletRequest request, HttpServletResponse response) {
        List<Dept> deptList = DaoFactory.getDeptDAO().getAll();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        Field[] fields = Dept.class.getDeclaredFields();
        for( int i=0; i<=deptList.size(); i++ ){
            HSSFRow row = sheet.createRow(i);
            if ( i==0 ) {
                for (int j = 0; j < fields.length; j++) {
                    fields[j].setAccessible(true);
                    HSSFCell cell = row.createCell((short) j);
                    cell.setCellValue(fields[j].getName());
                    System.out.println(fields[j].getName());
                }
            }
            else {
                Dept dept = deptList.get(i-1);
                HSSFCell cell1 = row.createCell((short) 0);
                HSSFCell cell2 = row.createCell((short) 1);
                HSSFCell cell3 = row.createCell((short) 2);
                cell1.setCellValue(dept.getDeptname());
                cell2.setCellValue(dept.getLoc());
                cell3.setCellValue(dept.getNum());
            }
        }
        String outputPath = request.getServletContext().getRealPath("/output");
        File fileDir = new File(outputPath);
        if( !fileDir.exists() ) fileDir.mkdirs();
        try {
            OutputStream out = new FileOutputStream(new File(fileDir,new Date().getTime()+".xls"));
            wb.write(out);
            response.sendRedirect("excelList.do");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
