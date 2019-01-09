package com.hellojava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hellojava.entity.Book;
@Mapper
public interface IBookDao {
	@Select("select * from book")
	public List<Book> loadAll();
	
	@Select("select * from book where bookId=#{bookId}")
	public Book loadById(int bookId);
}
