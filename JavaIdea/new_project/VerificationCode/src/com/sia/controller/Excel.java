package com.sia.controller;

import com.sia.bean.Dept;
import com.sia.dao.DaoFactory;
import com.sia.dao.GetExcelData;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/excel.do")
public class Excel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getParameter("method");
        switch ( method ){
            case "uploadExcel":
                uploadAndUpdate(request,response);
                break;
        }
    }

    private void uploadAndUpdate(HttpServletRequest request, HttpServletResponse response){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItemList = null;
        try {
            fileItemList = upload.parseRequest(request);
            for( FileItem f:fileItemList ){
                if( !f.isFormField() ){
                    String fileName = f.getName();
                    String filePath = request.getServletContext().getRealPath("/upload/excel");
                    File dir = new File(filePath);
                    if( !dir.exists() ) dir.mkdirs();
                    f.write(new File(dir,fileName));
                    String path = filePath+File.separator+fileName;
                    writeToSQL(path);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void writeToSQL(String path) throws IOException {
        InputStream in = new FileInputStream(path);
        POIFSFileSystem poi = new POIFSFileSystem(GetExcelData.class.getResourceAsStream("test.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(poi);
        for( int i=0; i<wb.getNumberOfSheets(); i++ ){
            HSSFSheet sheet = wb.getSheetAt(i);
            for (int j = sheet.getFirstRowNum()+1; j <=sheet.getLastRowNum(); j++) {
                HSSFRow row = sheet.getRow(j);
                Dept dept =  new Dept();
                for (int m = row.getFirstCellNum(); m < row.getLastCellNum(); m++) {
                    HSSFCell cell = row.getCell((short)m);
                    switch (m-row.getFirstCellNum()) {
                        case 0:
                            dept.setDeptname(cell.getRichStringCellValue().toString());
                            break;
                        case 1:
                            dept.setLoc(cell.getRichStringCellValue().toString());
                            break;
                        case 2:
                            dept.setNum((int)cell.getNumericCellValue());
                            break;
                    }
                }
                DaoFactory.getDeptDAO().add(dept);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
