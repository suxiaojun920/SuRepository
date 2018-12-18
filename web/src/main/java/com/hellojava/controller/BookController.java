package com.hellojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellojava.business.IBookService;
import com.hellojava.entity.Book;

@Controller
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/loadAll")
	public String loadAll(Model model) {
		List<Book> bookList=bookService.loadAll();
		model.addAttribute("bookList", bookList);
		return "index";
	}
}
