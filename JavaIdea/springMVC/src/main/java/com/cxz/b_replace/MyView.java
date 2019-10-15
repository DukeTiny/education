package com.cxz.b_replace;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MyView implements View {

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("MyView.render$$$$$$$$$$$$$$$$$$");
        request.getRequestDispatcher("/b1.jsp").forward(request,response);
    }
}
