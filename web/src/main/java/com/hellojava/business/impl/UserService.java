package com.hellojava.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.business.IUserService;
import com.hellojava.database.dao.IUserDao;
import com.hellojava.entity.User;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public boolean checkUser(User user) {
		User u=userDao.loadUser(user);
		return u!=null?true:false;
	}

}
