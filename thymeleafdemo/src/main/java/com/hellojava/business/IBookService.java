package com.hellojava.business;

import com.hellojava.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> loadAll(int page, int rows);
}
