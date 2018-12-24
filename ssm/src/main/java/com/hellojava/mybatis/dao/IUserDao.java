package com.hellojava.mybatis.dao;
import org.apache.ibatis.annotations.Mapper;

import com.hellojava.entity.User;
@Mapper
public interface IUserDao {
	public User loadUser(User user);
}
