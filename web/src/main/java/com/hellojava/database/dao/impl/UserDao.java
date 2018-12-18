package com.hellojava.database.dao.impl;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hellojava.database.dao.IUserDao;
import com.hellojava.entity.User;

@Repository("userDao")
public class UserDao extends JdbcDaoSupport implements IUserDao {
	@Autowired
	private void init(DataSource dataSource) {
		setDataSource(dataSource);
	}
	@Override
	public User loadUser(User u) {
		String sql="select * from users where userName=? and userPwd=?";
		return this.getJdbcTemplate().query(conn->{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getUserPwd());
			return ps;
		},rs->{
			User user=null;
			if(rs.next()) {
				user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
			}
			return user;
		});
	}

}
