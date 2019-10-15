package com.cxz.controller;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;
import com.cxz.service.ServiceFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/manageProduct.do")
public class ManagerProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method==null) updateProduct(request,response);
        else {
            switch (method) {
                case "showProduct":
                    showProduct(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "del":
                    del(request, response);
                    break;
            }
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = null;
        Product product = new Product();
        try {
            fileItems = upload.parseRequest(request);
            for( FileItem f:fileItems ){
                if( f.isFormField() ) {
                    String fieldName = f.getFieldName();
                    switch (fieldName){
                        case "productID" :
                            product.setProductID(Integer.parseInt(f.getString("utf-8")));
                            break;
                        case "productName" :
                            product.setProductName(f.getString("utf-8"));
                            break;
                        case "productBrand" :
                            product.setProductBrand(f.getString("utf-8"));
                            break;
                        case "typeID" :
                            product.setTypeID(Integer.parseInt(f.getString("utf-8")));
                            break;
                        case "unitPrice" :
                            product.setUnitPrice(Float.parseFloat(f.getString("utf-8")));
                            break;
                        case "unit" :
                            product.setUnit(f.getString("utf-8"));
                            break;
                        case "onSale" :
                            product.setOnSale(f.getString("utf-8").equals("上架")?0:1);
                            break;
                        case "priority" :
                            product.setPriority(f.getString("utf-8"));
                            break;
                        case "add":
                            add(request,response);
                            break;
                    }
                }
                else{
                    String filePath = request.getServletContext().getRealPath("/upload");
                    File file = new File(filePath);
                    if( !file.exists()) file.mkdirs();
                    String fileName = new Date().getTime()+f.getName().substring(f.getName().lastIndexOf("."));
                    product.setProductPhoto("/upload/"+fileName);
                    f.write(new File(file,fileName));
                }
            }
            Product temp = ServiceFactory.getProductService().getOne(product.getProductID());
            String fileName = temp.getProductPhoto();
            File file = new File(request.getServletContext().getRealPath("")+fileName);
            if( file.exists() ) file.delete();
            ServiceFactory.getProductService().update(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        showProduct(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productName = request.getParameter("productName");
        String productBrand = request.getParameter("productBrand");
        Integer typeID = Integer.parseInt(request.getParameter("typeID"));
        Float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
        String unit = request.getParameter("unit");
        String productPhoto = request.getParameter("productPhoto");
        Integer onSale = Integer.parseInt(request.getParameter("onSale"));
        String priority = request.getParameter("priority");
        Product product = new Product(null,productName,productBrand,typeID,unitPrice,unit,productPhoto,onSale,priority);
        ServiceFactory.getProductService().add(product);
        response.sendRedirect("iFrame.jsp");
    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productID = Integer.parseInt(request.getParameter("productID"));
        Product product = ServiceFactory.getProductService().getOne(productID);
        String fileName = product.getProductPhoto();
        File file = new File(request.getServletContext().getRealPath("")+fileName);
        if( file.exists() ) file.delete();
        ServiceFactory.getProductService().del(productID);
        showProduct(request,response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productID = Integer.parseInt(request.getParameter("prodID"));
        Product product = ServiceFactory.getProductService().getOne(productID);
        JSONArray jsonArray = JSONArray.fromObject(product);
        response.getWriter().write(jsonArray.toString());
        response.getWriter().flush();
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pageNum = request.getParameter("pageNum");
        PageBean pb = new PageBean();
        if( pageNum==null ) pb.setNowPage(1);
        else pb.setNowPage(Integer.parseInt(pageNum));
        pb.setEachPageRows(1);
        List<Product> list = ServiceFactory.getProductService().findByPageNum(pb);
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
