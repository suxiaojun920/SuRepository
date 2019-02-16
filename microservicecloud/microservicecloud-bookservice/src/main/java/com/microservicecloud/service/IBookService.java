package com.microservicecloud.service;

import java.util.List;

import com.microservicecloud.api.Book;

public interface IBookService {
	public List<Book> loadAll();
	public boolean save(Book book);
	public boolean delete(Book book);
	public boolean update(Book book);
	public Book get(int bookId);
}
