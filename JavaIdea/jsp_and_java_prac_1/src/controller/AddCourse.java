package controller;

import com.sia.dao.CourseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/course.add" )
public class AddCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String cnum = request.getParameter("cnum");
        com.sia.bean.Course course = new com.sia.bean.Course(cno,cname,cnum);
        CourseDao cd = new CourseDao();
        cd.add(course);
        List<com.sia.bean.Course> list = cd.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("showCourse.do").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
