package com.hellojava.ssh.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hellojava.entity.Book;
import com.hellojava.mybatis.dao.IBookDao;
import com.hellojava.ssh.business.IBookService;

@Service("bookService")
public class BookService implements IBookService{
	@Autowired
	private IBookDao bookDao;
	@Override
	public List<Book> loadPage(int page, int rows) {
		System.out.println(page+"---"+rows);
		PageHelper.startPage(page, rows);
		List<Book> bookList=bookDao.loadPage();
		return bookList;
	}
	@Override
	public int getMaxPage(int rows) {
		int count=bookDao.getCount();
		return count%rows==0?count/rows:count/rows+1;
	}

}
