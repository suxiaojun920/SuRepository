package com.hellojava.ssh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellojava.entity.Book;
import com.hellojava.ssh.business.IBookService;

@Controller
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/loadAll")
	@ResponseBody
	public Map<String, Object> loadAll(@RequestParam(required=false,defaultValue="1")int page,@RequestParam(required=false,defaultValue="10")int rows,Model model) {
		int count=bookService.getMaxCount();
		List<Book> bookList=bookService.loadPage(page, rows);
		Map<String, Object> maps=new HashMap<>();
		maps.put("total", count);
		maps.put("rows", bookList);
		return maps;
	}
}
