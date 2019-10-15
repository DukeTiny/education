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
		//���ô����ļ���Ϣ
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�ϴ��ͽ���
		ServletFileUpload upload = new ServletFileUpload(factory);
		//������еı���
		try {
			List<FileItem> lists = upload.parseRequest(request);
			for(FileItem item:lists){
				System.out.println(item);
				//�ж���Ŀ�Ƿ�Ϊ��ͨ����
				if(item.isFormField()){
					//��ñ��ؼ������� uname
//					item.getName();
					//������ֶ�Ӧ��ֵ �ı��������ֵ
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
