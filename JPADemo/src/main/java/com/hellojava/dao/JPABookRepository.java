package com.hellojava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellojava.entity.Book;

public interface JPABookRepository extends JpaRepository<Book, Integer>{
	
}
