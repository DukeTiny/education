package com.woniu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.woniu.bean.Stu;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class StuController
 */
@WebServlet("/stu.do")
public class StuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}else if("findAll".equals(method)){
			findAll(request,response);
		}else if("del".equals(method)){
			del(request,response);
		}else if("findOne".equals(method)){
			findOne(request,response);
		}else if("edit".equals(method)){
			edit(request,response);
		}
	}


	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Stu stu = new Stu();
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					if(item.getFieldName().equals("sname")){
						String sname = item.getString("utf-8");
						stu.setSname(sname);
					}else if(item.getFieldName().equals("sid")){
						String sid = item.getString();
						stu.setSid(Integer.parseInt(sid));
					}
				}else{
					String path = request.getServletContext().getRealPath("/upload");
					String fileName = item.getName();
					String hz = fileName.substring(fileName.lastIndexOf("."));
					String qz = String.valueOf(new Date().getTime());
					stu.setSphoto("/upload"+File.separator+qz+hz);
					File file = new File(path+File.separator+qz+hz);
					item.write(file);
				}
			}
			Stu temp = ServiceFactory.getStuService().getStuBySid(stu.getSid());
			String path = request.getServletContext().getRealPath("/");
			File file = new File(path+temp.getSphoto());
			if(file.exists()){
				file.delete();
			}
			//调用方法
			ServiceFactory.getStuService().editStu(stu);
			//跳转页面
			response.sendRedirect("stu.do?method=findAll");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		Stu s = ServiceFactory.getStuService().getStuBySid(Integer.parseInt(sid));
		request.setAttribute("stu", s);
		request.getRequestDispatcher("StuEdit.jsp").forward(request, response);
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sid = request.getParameter("sid");
		Stu s = ServiceFactory.getStuService().getStuBySid(Integer.parseInt(sid));
		String photoPath = s.getSphoto();
		photoPath = photoPath.substring(photoPath.lastIndexOf("/")+1);
		File f = new File(request.getServletContext().getRealPath("/")+File.separator+photoPath);
		if(f.exists()){
			f.delete();
		}
		ServiceFactory.getStuService().delStu(Integer.parseInt(sid));
		response.sendRedirect("stu.do?method=findAll");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Stu> stus = ServiceFactory.getStuService().getAllStus();
		request.setAttribute("stus", stus);
		request.getRequestDispatcher("StuList.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Stu stu = new Stu();
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					if(item.getFieldName().equals("sname")){
						String sname = item.getString("utf-8");
						System.out.println(sname+"++++++++++++++++++++");
						stu.setSname(sname);
					}
				}else{
					String path = request.getServletContext().getRealPath("/upload");
					String fileName = item.getName();
					String hz = fileName.substring(fileName.lastIndexOf("."));
					String qz = String.valueOf(new Date().getTime());
					stu.setSphoto("/upload"+File.separator+qz+hz);
					File file = new File(path+File.separator+qz+hz);
					item.write(file);
				}
			}
			//调用方法
			ServiceFactory.getStuService().addStu(stu);
			//跳转页面
			response.sendRedirect("stu.do?method=findAll");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
