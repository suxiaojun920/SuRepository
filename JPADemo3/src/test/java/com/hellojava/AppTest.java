package com.hellojava;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AppTest{
	@Test
	public void test() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dataSource");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
	}
}
