package com.hellojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping("/login")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping("/hello")
	public String helloView() {
		return "hello";
	}
}
