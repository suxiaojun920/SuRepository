package com.microservicecloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicecloud.api.Book;
import com.microservicecloud.dao.IBookDao;
import com.microservicecloud.service.IBookService;

@Service
public class BookService implements IBookService{
	@Autowired
	private IBookDao bookDao;
	@Override
	public List<Book> loadAll() {
		// TODO Auto-generated method stub
		return bookDao.loadAll();
	}
	@Override
	public boolean save(Book book) {
		int count=bookDao.save(book);
		return count>0?true:false;
	}
	@Override
	public boolean delete(Book book) {
		System.out.println("BookService"+book);
		int count=bookDao.delete(book);
		return count>0?true:false;
	}
	@Override
	public boolean update(Book book) {
		int count=bookDao.update(book);
		return count>0?true:false;
	}
	@Override
	public Book get(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.get(bookId);
	}
	
}
