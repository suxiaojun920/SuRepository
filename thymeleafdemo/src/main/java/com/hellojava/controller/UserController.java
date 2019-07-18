package com.hellojava.controller;

import com.hellojava.business.IUserService;
import com.hellojava.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @ModelAttribute
    public User init(){
        return new User();
    }
    @RequestMapping(value = "/login.view")
    public String helloView(@ModelAttribute User user,Model model){
        boolean bool=false;
        if(user.getUserName()!=null && user.getUserPwd()!=null) {
            bool = userService.loadUser(user);
        }
        return bool ? "redirect:/loadAllBook" : "login";
    }
}
