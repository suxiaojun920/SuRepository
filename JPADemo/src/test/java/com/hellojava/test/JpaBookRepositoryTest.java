package com.hellojava.test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hellojava.dao.JPABookRepository;
import com.hellojava.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JpaBookRepositoryTest {
	@Autowired
	private JPABookRepository bookRepository;
	
	@Test
	public void testQuery() {
		List<Book> bookList=bookRepository.findAll();
		bookList.forEach(System.out::println);
	}
	
	@Test
	public void testFind() {
//		Book b=new Book();
//		b.setBookId(1);
		//不使用懒加载(根据实体对象模型查询数据)
//		Optional<Book> book=bookRepository.findOne(Example.of(b));
//		bookRepository.findById(id)
		//注意使用懒加载(默认情况汇报no session异常 在spring配置文件中的entityManagerFactory中添加
		//修改不使用懒加载
		//<property name="jpaProperties">
		//	<props>
		//		<prop key="hibernate.enable_lazy_load_no_trans">true</prop>
		//	</props>
		//</property>
		//根据ID查找数据
//		Book book=bookRepository.getOne(1);
		
//		long count=bookRepository.count();
//		
//		System.out.println(count);
		
		
	}
	
	@Test
	public void testSave() {
		Book b=new Book();
		b.setBookName("JPA");
		b.setBookAuthor("李四");
		b.setBookPrice(55.66);
		b.setBookInfo("测试数据");
		
//		bookRepository.save(b);
		
	}
	//JPA不支持直接update操作(1:使用save)
	@Test
	public void testUpdate() {
		Book b=new Book();
		b.setBookId(2);
		b.setBookName("JPAUpdate");
		b.setBookAuthor("hello");
		b.setBookPrice(55.66);
		b.setBookInfo("测试");
		
		bookRepository.save(b);
	}
	
	@Test
	public void testDelete() {
		Book b=new Book();
		b.setBookId(3);
		
		bookRepository.delete(b);
	}
}
