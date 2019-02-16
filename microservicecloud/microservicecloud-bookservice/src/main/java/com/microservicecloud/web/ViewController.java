package com.microservicecloud.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservicecloud.api.Book;
import com.microservicecloud.service.IBookService;

@RestController
public class ViewController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(path= {"book/loadAll"},method=RequestMethod.GET)
	public List<Book> loadAll(){
		return bookService.loadAll();
	}
	
	@RequestMapping(path= {"book/load/{bookId}"},method=RequestMethod.GET)
	public Book load(@PathVariable("bookId")int bookId) {
		return bookService.get(bookId);
	}
	
	@RequestMapping(path= {"book/add"},method=RequestMethod.POST)
	public boolean save(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@RequestMapping(path= {"book/delete"},method=RequestMethod.POST)
	public boolean delete(@RequestBody Book book) {
		System.out.println(book);
		return bookService.delete(book);
	}
	
	@RequestMapping(path= {"book/update"},method=RequestMethod.POST)
	public boolean update(@RequestBody Book book) {
		return bookService.update(book);
	}
}
