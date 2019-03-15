package org.microservicecloud.bookservice.comsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicecloud.api.Book;

@RestController
public class ComsumerController {
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping(value="/consumer/book/save")
	public boolean save(Book book) {
		return restTemplate.postForObject("http://localhost:8001/book/add", book, Boolean.class);
	}
	@RequestMapping(value="/consumer/book/delete")
	public boolean delete(Book book) {
		return restTemplate.postForObject("http://localhost:8001/book/delete", book, Boolean.class);
	}
	@RequestMapping(value="/consumer/book/update")
	public boolean update(Book book) {
		return restTemplate.postForObject("http://localhost:8001/book/update", book, Boolean.class);
	}
	@RequestMapping(value="/consumer/book/load/{bookId}")
	public Book load(@PathVariable("bookId")int bookId) {
		return restTemplate.getForObject("http://localhost:8001/book/load/"+bookId, Book.class);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/book/loadAll")
	public List<Book> loadAll() {
		return restTemplate.getForObject("http://localhost:8001/book/loadAll", List.class);
	}
}
