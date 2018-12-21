package com.hellojava.ssh.business;

import java.util.List;

import com.hellojava.entity.Book;

public interface IBookService {
	public List<Book> loadPage(int page,int rows);
	public int getMaxPage(int rows);
}
