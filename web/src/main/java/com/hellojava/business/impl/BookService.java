package com.hellojava.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.business.IBookService;
import com.hellojava.database.dao.IBookDao;
import com.hellojava.entity.Book;

@Service("bookService")
public class BookService implements IBookService {
	@Autowired
	private IBookDao bookDao;
	@Override
	public List<Book> loadAll() {
		return bookDao.loadAll();
	}

}
