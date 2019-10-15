package com.cxz.controller;

import com.cxz.bean.PageBean;
import com.cxz.bean.Stock;
import com.cxz.service.ServiceFactory;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@WebServlet("/manageStock.do")
public class ManageStock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method) {
            case "showStock":
                showStock(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "del":
                del(request, response);
                break;
            case "submit":
                try {
                    submit(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "add":
                add(request,response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productID = Integer.parseInt(request.getParameter("productID"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Float primeCost = Float.parseFloat(request.getParameter("primeCost"));
        String purchaseDate = request.getParameter("purchaseDate");
        String supplier = request.getParameter("supplier");
        String buyer = request.getParameter("buyer");
        Stock stock = new Stock(null,productID,quantity,primeCost,purchaseDate,supplier,buyer);
        ServiceFactory.getStockService().add(stock);
        response.sendRedirect("iFrame.jsp");
    }

    private void submit(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        Integer purchaseID = Integer.parseInt(request.getParameter("purchaseID"));
        Integer productID = Integer.parseInt(request.getParameter("productID"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Float primeCost = Float.parseFloat(request.getParameter("primeCost"));
        String purchaseDate = request.getParameter("purchaseDate");
        String supplier = request.getParameter("supplier");
        String buyer = request.getParameter("buyer");
        Stock stock = new Stock(purchaseID,productID,quantity,primeCost,purchaseDate,supplier,buyer);
        ServiceFactory.getStockService().update(stock);
        showStock(request,response);
    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer typeID = Integer.parseInt(request.getParameter("purchaseID"));
        ServiceFactory.getProductTypeService().del(typeID);
        showStock(request,response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer purchaseID = Integer.parseInt( request.getParameter("purchaseID") );
        Stock stock = ServiceFactory.getStockService().getOne(purchaseID);
        stock.setPurchaseDate(stock.getPurchaseDate().substring(0,10));
        String pageNum = request.getParameter("pageNum");
        PageBean pb = new PageBean();
        if( pageNum==null ) pb.setNowPage(1);
        else pb.setNowPage(Integer.parseInt(pageNum));
        pb.setEachPageRows(1);
        Map<String,Object> map = new HashMap<>();
        List<Stock> list = new ArrayList<>();
        list.add(stock);
        map.put("list",list);
        map.put("pageBean",pb);
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void showStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pageNum = request.getParameter("pageNum");
        PageBean pb = new PageBean();
        if( pageNum==null ) pb.setNowPage(1);
        else pb.setNowPage(Integer.parseInt(pageNum));
        pb.setEachPageRows(1);
        List<Stock> list = ServiceFactory.getStockService().findByPageNum(pb);
        for( Stock s:list ){
            s.setPurchaseDate(s.getPurchaseDate().substring(0,10));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("pageBean",pb);
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
    }
}
