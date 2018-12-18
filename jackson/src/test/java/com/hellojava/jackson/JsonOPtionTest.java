package com.hellojava.jackson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hellojava.entity.Book;

public class JsonOPtionTest {
	private JsonOption json;

	@Before
	public void init() {
		json = new JsonOption();
	}

	@Test
	public void testWrite() {
		List<Book> bookList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Book b = new Book();
			b.setBookId(i + 1);
			b.setBookName("Java权威指南" + (i + 1));
			b.setBookAuthor(i % 2 == 0 ? "张三" : "李四");
			b.setBookPrice(33.44 + i);
			b.setBookInfo("测试数据");
			bookList.add(b);
		}
		json.write(bookList, "D:\\data.json");
	}
	
	@Test
	public void testRead() {
		List<Book> bookList=(List<Book>)json.read("D:\\data.json");
		for(Book b : bookList) {
			System.out.println(b);
		}
	}
	
	@Test
	public void testRead1() {
		List<Book> bookList=(List<Book>)json.read1("D:\\data.json",List.class,Book.class);
		for(Book b : bookList) {
			System.out.println(b);
		}
	}
}








