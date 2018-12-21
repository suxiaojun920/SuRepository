package com.hellojava.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellojava.entity.User;
import com.hellojava.ssh.business.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/loginHandler")
	public String loginHandler(User user) {
		boolean bool=userService.checkUser(user);
		return bool?"redirect:loadAll":"error";
	}
}
