package com.sia.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.sia.bean.Stu;
import com.sia.service.ServiceFactory;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/upload.do")
public class Upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "addStu" :
                addstu(request,response);
                break;
            case "delStu" :
                delStu(request,response);
                break;
            case "getAll":
                getAll(request,response);
                break;
            case "askEditStu":
                askEditStu(request,response);
                break;
            case "editStu":
                editStu(request,response);
                break;
        }
    }

    private void editStu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            Stu orignalStu = null;
            Stu stu = new Stu();
            for( FileItem f: fileItems ){
                if( f.isFormField() ){
                    String fieldName = f.getFieldName();
                    switch (fieldName){
                        case "sname":
                            stu.setsName(f.getString());
                            break;
                        case "sid":
                            orignalStu = ServiceFactory.getStuService().getOne(Integer.parseInt(f.getString()));
                            stu.setSid(Integer.parseInt(f.getString()));
                            break;
                    }
                }
                else {
                    File file = new File(request.getServletContext().getRealPath("/upload"));
                    if( !file.exists() ) file.mkdirs();
                    StringBuilder fileName = new StringBuilder(String.valueOf(new Date().getTime()));
                    fileName.append(f.getName().substring(f.getName().lastIndexOf(".")));
                    stu.setsPhoto("/upload"+File.separator+fileName.toString());
                    fileName.insert(0,File.separator);
                    fileName.insert(0,file.getAbsolutePath());
                    f.write(new File(fileName.toString()));
                }
            }
            ServiceFactory.getStuService().update(stu);
            if( ServiceFactory.getStuService().isDone() ){
                StringBuilder sb = new StringBuilder(request.getServletContext().getRealPath(""));
                sb.append(orignalStu.getsPhoto());
                File file = new File(sb.toString());
                System.out.println(sb.toString());
                if( file.exists() ){
                    if( file.delete() ){
                        response.sendRedirect("list.jsp");
                    }
                }
                else {
                    response.sendRedirect("list.jsp");
                }
            }
            else {
                ServiceFactory.getStuService().update(orignalStu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void askEditStu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        Stu stu = ServiceFactory.getStuService().getOne(sid);
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) {
        List<Stu> stuList = ServiceFactory.getStuService().getAll();
        JSONArray jsonArray = JSONArray.fromObject(stuList);
        try {
            response.getWriter().write(jsonArray.toString());
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void delStu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        Stu stu = ServiceFactory.getStuService().getOne(sid);
        StringBuilder sb = new StringBuilder(request.getServletContext().getRealPath(""));
        sb.append(stu.getsPhoto());
        File file = new File(sb.toString());
        if( file.exists() ){
            file.delete();
            ServiceFactory.getStuService().del(sid);
            getAll(request,response);
        }

    }


    private void addstu(HttpServletRequest request, HttpServletResponse response) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            Stu stu = new Stu();
            for( FileItem f:fileItems ){
                if( f.isFormField() ){
                    String fieldName = f.getFieldName();
                    switch (fieldName){
                        case "sname":
                            stu.setsName(f.getString());
                            break;
                    }
                }
                else {
                    File file = new File(request.getServletContext().getRealPath("/upload"));
                    if( !file.exists() ) file.mkdirs();
                    StringBuilder fileName = new StringBuilder(String.valueOf(new Date().getTime()));
                    fileName.append(f.getName().substring(f.getName().lastIndexOf(".")));
                    stu.setsPhoto("/upload"+File.separator+fileName.toString());
                    fileName.insert(0,File.separator);
                    fileName.insert(0,file.getAbsolutePath());
                    f.write(new File(fileName.toString()));
                }
            }
            ServiceFactory.getStuService().add(stu);
            response.sendRedirect("list.jsp");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
