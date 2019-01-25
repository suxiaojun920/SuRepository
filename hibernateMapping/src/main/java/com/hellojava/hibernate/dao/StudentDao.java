package com.hellojava.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hellojava.hibernate.HibernateSessionFactory;
import com.hellojava.hibernate.entity.Student;

public class StudentDao {
	public int save(Student s) {
		Session session=HibernateSessionFactory.getSession();
		Transaction t=session.beginTransaction();
		int id=0;
		try {
			id=(int) session.save(s);
			t.commit();
		}catch(Exception e) {
			t.rollback();
		}
		return id;
	}
}
