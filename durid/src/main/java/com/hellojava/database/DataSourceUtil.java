package com.hellojava.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DataSourceUtil {
	private static DataSource dataSource;
	static {
		InputStream inStream=DataSourceUtil.class.getResourceAsStream("/db.properties");
		Properties p=new Properties();
		try {
			p.load(inStream);
			dataSource=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn=null;
		if(dataSource!=null) {
			conn=dataSource.getConnection();
		}
		return conn;
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
