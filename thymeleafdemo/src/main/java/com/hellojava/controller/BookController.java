package com.hellojava.controller;

import com.hellojava.business.IBookService;
import com.hellojava.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @RequestMapping(value = "/loadAllBook")
    public String loadAll(@RequestParam(required = false,defaultValue = "1") int page, @RequestParam(required = false,defaultValue = "10") int rows, Model model){
        List<Book> bookList=bookService.loadAll(page,rows);
        model.addAttribute("bookList",bookList);
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        return "index";
    }
}
