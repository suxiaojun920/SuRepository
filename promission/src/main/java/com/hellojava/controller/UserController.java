package com.hellojava.controller;

import com.hellojava.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("loginHandler")
    public String loginHandler(User user, HttpSession session){
        if("admin".equals(user.getUserName()) && "a111".equals(user.getUserPwd())){
            session.setAttribute("currentUser",user);
            return "index.html";
        }else{
            return "error.html";
        }
    }
}
