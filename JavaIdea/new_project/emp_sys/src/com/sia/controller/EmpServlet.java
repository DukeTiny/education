package com.sia.controller;

import com.sia.bean.Dept;
import com.sia.bean.Emp;
import com.sia.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/empServlet.do")
public class EmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ( method==null || method.equals("getAllEmp") ){
            getAll(request,response);
        }
        else if( method.equals("addEmpWindow")) {
            getAllForAdd(request,response);
        }
        else if( method.equals("confirmAddEmp") ){
            addEmp(request,response);
        }
    }

    private void addEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer empno = Integer.parseInt( request.getParameter("empno") );
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        Integer mgr = Integer.parseInt( request.getParameter("mgr") );
        String[] date = request.getParameterValues("hiredate");
        Date hiredate = new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]));
        Double sal = Double.parseDouble( request.getParameter("sal"));
        Double comm = Double.parseDouble( request.getParameter("comm"));
        Integer deptno = Integer.parseInt( request.getParameter("deptno") );
        Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
        ServiceFactory.getEmpService().add(emp);
        response.sendRedirect("empServlet.do?method=getAllEmp");
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> emps = ServiceFactory.getEmpService().getAll();
        request.setAttribute("emps", emps);
        List<Dept> depts = ServiceFactory.getDeptService().getAll();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("empList.jsp").forward(request,response);
    }
    private void getAllForAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> emps = ServiceFactory.getEmpService().getAll();
        request.setAttribute("emps", emps);
        List<Dept> depts = ServiceFactory.getDeptService().getAll();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("addEmp.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
