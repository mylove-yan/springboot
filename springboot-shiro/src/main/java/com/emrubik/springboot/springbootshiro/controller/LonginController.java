package com.emrubik.springboot.springbootshiro.controller;

import com.emrubik.springboot.springbootshiro.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LonginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(User user){
//
//        //添加用户认证信息
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
//                user.getUserName(),
//                user.getPassword()
//        );
//        try {
//            //进行验证，这里可以捕获异常，然后返回对应信息
//            subject.login(usernamePasswordToken);
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            return "账号或密码错误！";
//        } catch (AuthorizationException e) {
//            e.printStackTrace();
//            return "没有权限";
//        }
//        return "login success";
//    }
//
    @RequestMapping("/index")
    public String index(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("admin")){
            return "index";
        }else{
            throw new ShiroException("有问题");
        }
    }

    @RequestMapping("/loginUser")
    public String loginUser(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "login";
        }
        return "index";
    }

}
