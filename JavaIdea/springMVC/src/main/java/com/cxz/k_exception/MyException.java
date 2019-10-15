package com.cxz.k_exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        System.out.println("I'm Fucking Here");
        if( e instanceof ArithmeticException){
            return new ModelAndView("math");
        } else if( e instanceof ArrayIndexOutOfBoundsException ){
            return new ModelAndView("Out");
        } else {
            return new ModelAndView("NoName");
        }
    }
}
