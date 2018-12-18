package com.hellojava.test;

import java.sql.SQLException;

import org.junit.Test;

import com.hellojava.database.dao.BookDao;

public class BookDaoTest {
	@Test
	public void testLoadAll() throws SQLException {
		BookDao bookDao=new BookDao();
		bookDao.loadPage(0, 10).forEach(System.out::println);
	}
}
