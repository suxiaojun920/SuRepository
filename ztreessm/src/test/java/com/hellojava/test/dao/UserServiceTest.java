package com.hellojava.test.dao;

import com.hellojava.business.IUserService;
import com.hellojava.entity.Promission;
import com.hellojava.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testLoadPromission(){

    }
}
