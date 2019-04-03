package com.hellojava.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hellojava.entity.Book;

public class AppTest {
   private EntityManagerFactory entityManagerFactory;
   private EntityManager entityManager;
   
   @Before
   public void init() {
	   entityManagerFactory=Persistence.createEntityManagerFactory("datasource");
	   entityManager=entityManagerFactory.createEntityManager();   
   }
   
   
   @Test
   public void testSave() {
	   entityManager.getTransaction().begin();
	   Book book=new Book();
	   book.setBookId(5);
	   book.setBookName("Hibernate");
	   book.setBookAuthor("张无忌1");
	   book.setBookPrice(66.77);
	   book.setBookInfo("测试数据");
	   //当前的ID在数据库中存在为更新，不存在为save
//	   entityManager.merge(book);
	   //永远都是save()ID重复报错
	   entityManager.persist(book);
	   entityManager.getTransaction().commit();
   }
}
