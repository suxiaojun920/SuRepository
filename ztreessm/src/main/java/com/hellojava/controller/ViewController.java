package com.hellojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("loginview")
    public String loginView(){
        return "login.html";
    }

    @RequestMapping("indexview")
    public String indexView(){
        return "index.html";
    }

    @RequestMapping("userview")
    public String userView(){
        return "user.html";
    }
}
