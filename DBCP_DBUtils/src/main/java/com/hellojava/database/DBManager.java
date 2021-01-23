package com.hellojava.database;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private BasicDataSource basicDataSource;
    public DBManager(){
        initDataSource();
    }
    private void initDataSource(){
        basicDataSource=new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("a111");
        basicDataSource.setInitialSize(10); //设置初始链接数量
        basicDataSource.setMaxIdle(5);
    }
    public DataSource getDataSource() throws SQLException {
        return basicDataSource;
    }
}
