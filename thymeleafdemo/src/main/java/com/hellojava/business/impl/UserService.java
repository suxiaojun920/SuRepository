package com.hellojava.business.impl;

import com.hellojava.business.IUserService;
import com.hellojava.dao.UserDao;
import com.hellojava.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean loadUser(User user) {
        User u=userDao.loadUser(user);
        return u!=null?true:false;
    }
}
