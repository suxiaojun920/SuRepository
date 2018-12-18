package com.hellojava.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hellojava.database.DBManager;
import com.hellojava.entity.Book;

public class BookDao {
	private DBManager dbManager=new DBManager();
	
	public int getTotal() throws SQLException{
		int total=0;
		Connection conn=dbManager.openConnection();
		String sql="select count(bookId) from book";
		ResultSet rs=dbManager.query(conn, sql, null);
		if(rs.next()) {
			total=rs.getInt(1);
		}
		dbManager.closeConnection(conn);
		return total;
	}
	
	public List<Book> loadPage(int page,int rows)throws SQLException{
		Connection conn=dbManager.openConnection();
		String sql="select * from book limit ?,?";
		Object[] obs= {page,rows};
		ResultSet rs=dbManager.query(conn, sql, obs);
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
		dbManager.closeConnection(conn);
		return bookList;
	}
}