package com.hellojava.business.impl;

import com.github.pagehelper.PageHelper;
import com.hellojava.business.IBookService;
import com.hellojava.business.IUserService;
import com.hellojava.dao.BookDao;
import com.hellojava.entity.Book;
import com.hellojava.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> loadAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Book> bookList=bookDao.loadAll();
        return bookList;
    }
}
