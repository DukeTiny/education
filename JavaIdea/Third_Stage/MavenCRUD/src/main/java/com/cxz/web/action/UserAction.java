package com.cxz.web.action;

import com.cxz.bean.Page;
import com.cxz.bean.User;
import com.cxz.service.IUserService;
import com.cxz.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.lang.reflect.Proxy;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private IUserService service = new UserServiceImpl();
    private int p;
    private int size;

    public String save(){
        service.save(user);
        return "find";
    }

    public String find(){
        if(size==0) size=5;
        Page page = service.findPageData(p,size);
        ServletActionContext.getRequest().setAttribute("page",page);
        return "findUI";
    }
    public String delete(){
        service.delete(user.getId());
        return "find";
    }
    public String update(){
        service.update(user);
        return "find";
    }
    public String updateUI(){
        ServletActionContext.getRequest().setAttribute("user",service.find(user.getId()));
        return "updateUI";
    }

    public User getModel() {
        return user;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
