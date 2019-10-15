package com.cxz.g_httpmessageconverter.b;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyHttpMessageConverter extends AbstractHttpMessageConverter {

    @Override
    protected boolean supports(Class clazz) {
        return User.class==clazz;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream in = inputMessage.getBody();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (in.available()>0) {
            int len=in.read();
            bos.write(len);
        }
        byte[] buf = bos.toByteArray();
        String str = new String(buf);
        String[] data = str.split("---");
        User user = new User();
        user.setId(Integer.parseInt(data[0].split("##")[1]));
        user.setName(data[1].split("##")[1]);
        return user;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println(o);
        OutputStream body = outputMessage.getBody();
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(o);
        body.write(json.getBytes("UTF-8"));
        body.close();
    }
}
