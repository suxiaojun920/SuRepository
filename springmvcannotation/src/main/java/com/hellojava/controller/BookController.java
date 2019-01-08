package com.hellojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hellojava.business.IBookService;
import com.hellojava.entity.Book;

@RestController
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/loadAll")
	public List<Book> loadAll(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false,defaultValue="10") int rows){
		List<Book> bookList=bookService.loadAll(page,rows);
		return bookList;
	}
}
