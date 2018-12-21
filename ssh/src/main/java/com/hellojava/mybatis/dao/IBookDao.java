package com.hellojava.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hellojava.entity.Book;

@Mapper
public interface IBookDao {
	public List<Book> loadPage();
	public int getCount();
}
