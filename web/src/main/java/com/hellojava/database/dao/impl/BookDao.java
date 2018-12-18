package com.hellojava.database.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hellojava.database.dao.IBookDao;
import com.hellojava.entity.Book;

@Repository("bookDao")
public class BookDao extends JdbcDaoSupport implements IBookDao {
	@Autowired
	private void init(DataSource dataSource) {
		setDataSource(dataSource);
	}
	@Override
	public List<Book> loadAll() {
		String sql="select * from book";
		return this.getJdbcTemplate().query(sql, rs->{
			List<Book> bookList=new ArrayList<>();
			while(rs.next()) {
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setBookAuthor(rs.getString("bookAuthor"));
				b.setBookPrice(rs.getDouble("bookPrice"));
				b.setBookInfo(rs.getString("bookInfo"));
				
				bookList.add(b);
			}
			return bookList;
		});
	}

}
