package com.hellojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("indexview")
    public String indexView(){
        return "index.html";
    }

    @RequestMapping("loginview")
    public String loginView(){
        System.out.println("loginView");
        return "login.html";
    }

    @RequestMapping("testview")
    public String testView(){
        return "test.html";
    }

    @RequestMapping("assignview")
    public String assignView(){
        return "assignPermission.html";
    }

    @RequestMapping("indexjsonnview")
    public String indexjsonView(){
        return "indexjson.html";
    }

    @RequestMapping("promissionview")
    public String promissionView(){
        return "promission.html";
    }
}
