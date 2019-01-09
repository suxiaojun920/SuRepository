package com.hellojava.business;

import java.util.List;

import com.hellojava.entity.Book;

public interface IBookService {
	public List<Book> loadAll(int page,int rows);
	public Book loadById(int bookId);
}
