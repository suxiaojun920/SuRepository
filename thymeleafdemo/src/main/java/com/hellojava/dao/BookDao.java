package com.hellojava.dao;

import com.hellojava.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookDao {
    public List<Book> loadAll();
}
