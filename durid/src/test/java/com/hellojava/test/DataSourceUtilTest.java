package com.hellojava.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.hellojava.database.DataSourceUtil;

public class DataSourceUtilTest {
	@Test
	public void testGetConnection() {
		try {
			Connection conn=DataSourceUtil.getConnection();
			assertNotNull(conn);
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
