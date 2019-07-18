package com.hellojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("loginhtml")
    public String loginView(){
        return "login";
    }
}
