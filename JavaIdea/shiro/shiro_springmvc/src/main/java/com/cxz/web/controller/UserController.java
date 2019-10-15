package com.cxz.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login( String username,String password )  {
        System.out.println(username);
        System.out.println(password);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                System.out.println("认证成功");
                return "redirect:/index.html";
            } catch (UnknownAccountException uae) {
                System.out.println("用户名异常");
            } catch (IncorrectCredentialsException ice) {
                System.out.println("密码你丫的错了");
            } catch (LockedAccountException lae) {
                System.out.println("账户被锁定了");
            }
            catch (AuthenticationException ae) {
                System.out.println("异常不祥:自己看着办");
            }
        }

        return "redirect:/html/login.html";
    }

}
