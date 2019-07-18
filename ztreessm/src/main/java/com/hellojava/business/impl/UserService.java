package com.hellojava.business.impl;

import com.hellojava.business.IUserService;
import com.hellojava.dao.UserDao;
import com.hellojava.entity.Promission;
import com.hellojava.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service("userService")
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User loadUser(User u) {
        User user=userDao.loadUser(u);
        return user;
    }
}
