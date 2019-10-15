package com.alipay.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/param.do")
public class ParamTestController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] hobby = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobby));
    }
}
interface Test{
    StringBuilder sb = new StringBuilder();
}
class Test2 implements Test{
    public Test2(){
        sb.append("");
    }

    public static void main(String[] args) {
        System.out.println(sb.append("ss").append("asdasda"));
    }
}