package com.hellojava.ssh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellojava.entity.Book;
import com.hellojava.ssh.business.IBookService;

@Controller
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/loadAll")
	public String loadAll(@RequestParam(required=false,defaultValue="1")int page,@RequestParam(required=false,defaultValue="10")int rows,Model model) {
		int maxPage=bookService.getMaxPage(rows);
		if(page<1) {
			page=1;
		}
		if(page>maxPage) {
			page=maxPage;
		}
		List<Book> bookList=bookService.loadPage(page, rows);
		model.addAttribute("bookList", bookList);
		model.addAttribute("currentPage", page);
		model.addAttribute("maxPage", maxPage);
		return "index";
	}
}
