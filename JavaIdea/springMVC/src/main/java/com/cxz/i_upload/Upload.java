package com.cxz.i_upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class Upload {

    @RequestMapping("upload")
    public String f1(@RequestParam CommonsMultipartFile photo, HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/images/");
        System.out.println(path);
        File dir  = new File(path);
        if(!dir.exists()) dir.mkdirs();
        String name = UUID.randomUUID().toString();
        String fileName = photo.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        File file = new File(dir,name+ext);
        try {
            photo.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
