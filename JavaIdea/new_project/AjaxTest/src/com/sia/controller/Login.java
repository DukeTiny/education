package com.sia.controller;

import com.sia.bean.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.sia.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String method = request.getParameter("method");
        switch (method){
            case "list" : userList(request,response);
                break;
            case "list2" : userList2(request,response);
                break;
            case "getOne" : editForm(request,response);
                break;
            case "updateUser" : updateUser(request,response);
                break;
            case "addNewUser" : addNewUser(request,response);
                break;
            case "delUser" : delUser(request,response);
                break;
        }
    }

    private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        ServiceFactory.getUserService().del(uid);
        userList2(request,response);
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String urole = request.getParameter("urole");
        String ustatus = request.getParameter("ustatus").trim();
        User user = new User(null,uname,upwd,urole,ustatus);
        ServiceFactory.getUserService().add(user);
        userList2(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uid = request.getParameter("uid");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String urole = request.getParameter("urole");
        String ustatus = request.getParameter("ustatus");
        User user = new User(Integer.parseInt(uid),uname,upwd,urole,ustatus);
        ServiceFactory.getUserService().update(user);
        userList2(request,response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uid = request.getParameter("uid");
        User user = ServiceFactory.getUserService().getOne(Integer.parseInt(uid));
        JSONObject jsonObject = JSONObject.fromObject(user);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
    }

    private void userList2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<User> userList = ServiceFactory.getUserService().getAll();
        JSONArray jsonArray = JSONArray.fromObject(userList);
        response.getWriter().write(jsonArray.toString());
        response.getWriter().flush();
    }

    private void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        StringBuffer html = new StringBuffer();
        List<User> userList = ServiceFactory.getUserService().getAll();
        for ( int i=0; i<userList.size(); i++ ){
            html.append("<tr>");
            html.append("<td>"+(i+1)+"</td>");
            html.append("<td>"+userList.get(i).getUid()+"</td>");
            html.append("<td>"+userList.get(i).getuName()+"</td>");
            html.append("<td>"+userList.get(i).getuPwd()+"</td>");
            html.append("<td>"+userList.get(i).getuRole()+"</td>");
            html.append("<td>"+userList.get(i).getuStatus()+"</td>");
            html.append("</tr>");
        }
        response.getWriter().write(html.toString());
        response.getWriter().flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
