package com.cxz.web.action;

import com.cxz.domain.Dept;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class DeptAction extends ActionSupport implements ModelDriven<Dept> {

    private Dept dept = new Dept();

    public DeptAction() {
        System.out.println("DeptAction.DeptAction~~~~~~~~~~~~~~~~~");
    }

    public String save(){
        System.out.println("DeptAction.save........");
        return null;
    }



    @Override
    public Dept getModel() {
        return dept;
    }
}
