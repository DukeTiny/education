package com.cxz.controller;

import com.cxz.bean.PageBean;
import com.cxz.bean.ProductType;
import com.cxz.service.ServiceFactory;
import net.sf.json.JSONObject;
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
import java.util.*;

@WebServlet("/manageType.do")
public class ManageType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        switch (method) {
            case "showType":
                showType(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "del":
                del(request, response);
                break;
            case "submit":
                submit(request,response);
            break;
            case "add":
                add(request,response);
                break;
            case "addWithFile":
                try {
                    addWithFile(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void addWithFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        for( FileItem f:fileItems ){
            if(!f.isFormField()){
                String fileName = f.getName();
                fileName = new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
                File file = new File(request.getServletContext().getRealPath("/upload"));
                if( !file.exists()) file.mkdirs();
                File storeFile = new File(file,fileName);
                f.write(storeFile);
                String path = request.getServletContext().getRealPath("/upload/")+fileName;
                InputStream is = new FileInputStream(path);
                POIFSFileSystem poi = new POIFSFileSystem(is);
                HSSFWorkbook wb = new HSSFWorkbook(poi);
                for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                    HSSFSheet sheet = wb.getSheetAt(i);
                    for (int j = sheet.getFirstRowNum(); j <=sheet.getLastRowNum() ; j++) {
                        HSSFRow row = sheet.getRow(j);
                        ProductType pt = new ProductType();
                        for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                            HSSFCell cell = row.getCell((short)k);
                            switch (cell.getCellType()) {
                                case 0:
                                    pt.setTypeID((int)cell.getNumericCellValue());
                                    break;
                                case 1:
                                    pt.setTypeName(cell.getRichStringCellValue().toString());
                                    break;
                            }
                        }
                        ServiceFactory.getProductTypeService().add(pt);
                    }
                }
                storeFile.delete();
            }
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer typeID = Integer.parseInt(request.getParameter("typeID"));
        String typeName = request.getParameter("typeName");
        ProductType pt = new ProductType(typeID,typeName);
        ServiceFactory.getProductTypeService().add(pt);
        response.sendRedirect("iFrame.jsp");
    }

    private void submit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer typeId = Integer.parseInt(request.getParameter("typeID"));
        String typeName = request.getParameter("typeName");
        ServiceFactory.getProductTypeService().update(new ProductType(typeId,typeName));
        showType(request,response);
    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer typeID = Integer.parseInt(request.getParameter("productID"));
        ServiceFactory.getProductTypeService().del(typeID);
        showType(request,response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer typeID = Integer.parseInt( request.getParameter("typeID") );
        ProductType pt = ServiceFactory.getProductTypeService().getOne(typeID);
        String pageNum = request.getParameter("pageNum");
        PageBean pb = new PageBean();
        if( pageNum==null ) pb.setNowPage(1);
        else pb.setNowPage(Integer.parseInt(pageNum));
        pb.setEachPageRows(1);
        Map<String,Object> map = new HashMap<>();
        List<ProductType> list = new ArrayList<>();
        list.add(pt);
        map.put("list",list);
        map.put("pageBean",pb);
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
    }

    private void showType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pageNum = request.getParameter("pageNum");
        PageBean pb = new PageBean();
        if( pageNum==null ) pb.setNowPage(1);
        else pb.setNowPage(Integer.parseInt(pageNum));
        pb.setEachPageRows(1);
        List<ProductType> list = ServiceFactory.getProductTypeService().findByPageNum(pb);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("pageBean",pb);
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
