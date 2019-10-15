package controller;

import com.sia.bean.Course;
import com.sia.dao.CourseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEditCourse.do")
public class UpdateEditCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String cnum = request.getParameter("cnum");
        Course course = new Course(cno,cname,cnum);
        CourseDao cd = new CourseDao();
        cd.update(course);
        response.sendRedirect("showCourse.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
