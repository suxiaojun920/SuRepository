package com.hellojava.ssh.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.entity.User;
import com.hellojava.mybatis.dao.IUserDao;
import com.hellojava.ssh.business.IUserService;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Override
	public boolean checkUser(User user) {
		User u=userDao.loadUser(user);
		return u!=null?true:false;
	}
	
}
