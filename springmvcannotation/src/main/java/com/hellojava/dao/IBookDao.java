package com.hellojava.dao;

import java.util.List;

import com.hellojava.entity.Book;

public interface IBookDao {
	public List<Book> loadAll();
}
