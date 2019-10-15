package com.cxz;

import com.sun.tools.doclets.internal.toolkit.Content;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jnlp.FileContents;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument;
import java.nio.channels.ServerSocketChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.DELETE)
    public String test(ModelMap model/*ModelAndView modelAndView, HttpServletRequest request*/) {
        System.out.println("In it...");
//        modelAndView.setViewName("redirect:/test/forward");
//        request.setAttribute("test","This is Test");
        List<String> list = new ArrayList<>();
        list.add("Duke");
        list.add("Tiger@@@####");
        model.put("test",list);
        return "test";
    }
    @RequestMapping("/test2")
    public ModelAndView test2(){
        System.out.println("In it...2222");
        ArrayList list = new ArrayList();
        list.add("Duke");
        list.add("Tiger@@@####aaaa");
        Map map = new HashMap();
        map.put("ss","Tiger");
        ModelAndView mav = new ModelAndView("test");
        mav.addObject(list);
        mav.addObject(map);
        mav.addObject("AA");
        return mav;
    }

    @RequestMapping("/forward")
    public void test2( ModelAndView modelAndView,HttpServletRequest request ) {
        System.out.println("@@@@@@@@@@@@@");
        System.out.println(request.getAttribute("test"));
//        modelAndView.setViewName("forward:/forward");
//        modelAndView.addObject("test","This is Test");

    }

}
