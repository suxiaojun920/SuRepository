package com.hellojava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//读取hibernate.cfg.xml 创建SessionFactory 通过SessionFactory 创建Session
public class HibernateSessionFactory {
    private static String cfgFilePath="/hibernate.cfg.xml";
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    private static Configuration configuration=new Configuration();
    
    //只会再装载当前类的时候执行一次
    static {
    	StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure(cfgFilePath).build();
    	sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }
    
    private static void rebuilderSessionFactory() {
    	StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure(cfgFilePath).build();
    	sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }
    
    public static Session getSession() {
    	Session session=threadLocal.get();
    	if(session==null) {
    		if(sessionFactory==null)
    			rebuilderSessionFactory();
    		session=sessionFactory.openSession();
    		threadLocal.set(session);
    	}
    	return session;
    }
    
    public static void closeSession() {
    	Session session=threadLocal.get();
    	if(session!=null) {
    		session.close();
    		threadLocal.set(null);
    	}
    }
    
}
