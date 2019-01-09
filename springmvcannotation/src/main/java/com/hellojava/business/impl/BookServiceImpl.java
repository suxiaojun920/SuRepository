package com.hellojava.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hellojava.business.IBookService;
import com.hellojava.dao.IBookDao;
import com.hellojava.entity.Book;

@Service
public class BookServiceImpl implements IBookService{
	@Autowired
	private IBookDao bookDao;
	@Override
	public List<Book> loadAll(int page,int rows) {
		PageHelper.startPage(page, rows);
		return bookDao.loadAll();
	}
	@Override
	public Book loadById(int bookId) {
		return bookDao.loadById(bookId);
	}
	
}
