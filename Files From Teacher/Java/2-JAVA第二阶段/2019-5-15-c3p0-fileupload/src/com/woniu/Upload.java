package com.woniu;

import java.io.File;
import java.io.IOException;
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



/**
 * Servlet implementation class Upload
 */
@WebServlet("/upload.do")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//设置磁盘文件信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//上传和解析
		ServletFileUpload upload = new ServletFileUpload(factory);
		//获得所有的表单项
		try {
			List<FileItem> lists = upload.parseRequest(request);
			for(FileItem item:lists){
				System.out.println(item);
				//判断项目是否为普通表单项
				if(item.isFormField()){
					//获得表单控件的名字 uname
//					item.getName();
					//获得名字对应的值 文本框中填的值
//					item.getString();
				}else{
					String fileName = item.getName();  //1.jpg
					File file = new File(request.getServletContext().getRealPath("/upload"));
					if(!file.exists()){
						file.mkdirs();
					}
					item.write(new File(file,fileName));
				}
			}
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
