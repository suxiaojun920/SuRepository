package com.microservicecloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.microservicecloud.api.Book;

@Mapper
public interface IBookDao {
	public List<Book> loadAll();
	public int save(Book book);
	public int delete(Book book);
	public int update(Book book);
	public Book get(int bookId);
}
