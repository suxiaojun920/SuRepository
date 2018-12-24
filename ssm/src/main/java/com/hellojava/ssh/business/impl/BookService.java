package com.hellojava.ssh.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hellojava.entity.Book;
import com.hellojava.mybatis.dao.IBookDao;
import com.hellojava.ssh.business.IBookService;

@Service("bookService")
public class BookService implements IBookService{
	@Autowired
	private IBookDao bookDao;
	@Override
	public List<Book> loadPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<Book> bookList=bookDao.loadPage();
		return bookList;
	}
	@Override
	public int getMaxCount() {
		int count=bookDao.getCount();
		return count;
	}

}
