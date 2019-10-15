package com.cxz.web.controller;

import com.cxz.Service.IRoleService;
import com.cxz.Service.IUserRoleService;
import com.cxz.Service.IUserService;
import com.cxz.domain.User;
import com.cxz.domain.User_Role_Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Transactional
    @RequestMapping("reg")
    @ResponseBody
    public String reg(User user, String[] role){
        System.out.println(user);
        System.out.println(Arrays.toString(role));
        iUserService.save(user);
        int uid = iUserService.findId(user.getUsername());
        User_Role_Key urk = new User_Role_Key();
        urk.setUid(uid);
        System.out.println(uid);
        System.out.println(role.length);
        for ( String s:role ) {
            int rid = iRoleService.find(s);
            urk.setRid(rid);
            iUserRoleService.save(urk);
        }
        return "A";
    }

}
