package com.hellojava.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.hellojava")
public class SpringConfiuration {
	@Bean
	public DataSource getDataSource() {
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("a111");
		return dataSource;
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public PageInterceptor getPageInterceptor() {
		PageInterceptor interceptor=new PageInterceptor();
		Properties p=new Properties();
		p.setProperty("helperDialect", "mysql");
		interceptor.setProperties(p);
		return interceptor;
	}
	
	@Bean("sqlSessionFactory")
	@Autowired
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource,PageInterceptor pageInterceptor) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
		sqlSessionFactory.setTypeAliasesPackage("com.hellojava.entity");
		sqlSessionFactory.setPlugins(new Interceptor[] {pageInterceptor});
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/hellojava/mappers/*.xml"));
		sqlSessionFactory.setDataSource(dataSource);
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.hellojava.dao");
		return mapperScannerConfigurer;
	}
}
