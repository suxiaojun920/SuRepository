package com.hellojava.database.dao;

import com.hellojava.database.DBManager;
import com.hellojava.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    private DBManager dbManager=new DBManager();
    private QueryRunner getQueryRunner() throws SQLException {
        return new QueryRunner(dbManager.getDataSource());
    }
    public List<Student> loadAll() throws SQLException {
        QueryRunner queryRunner=getQueryRunner();
        return queryRunner.query("select * from student", new ResultSetHandler<List<Student>>() {
            @Override
            public List<Student> handle(ResultSet resultSet) throws SQLException {
                BeanListHandler beanListHandler=new BeanListHandler(Student.class);
                return beanListHandler.handle(resultSet);
            }
        });
    }

    public Student loadById(int id)throws SQLException{
        QueryRunner queryRunner=getQueryRunner();
        return queryRunner.query("select * from student where stuId=?", new ResultSetHandler<Student>() {
            @Override
            public Student handle(ResultSet resultSet) throws SQLException {
                BeanHandler beanHandler=new BeanHandler(Student.class);
                return (Student) beanHandler.handle(resultSet);
            }
        },new Object[]{id});
    }

    public boolean delete(int id)throws SQLException{
        QueryRunner queryRunner=getQueryRunner();
        int count=queryRunner.update("delete from student where stuId=?",new Object[]{id});
        return count>0?true:false;
    }

    public boolean save(Student s)throws SQLException{
        QueryRunner queryRunner=getQueryRunner();
        String sql="insert into student values(?,?,?,?,?)";
        int count=queryRunner.update(sql,new Object[]{s.getStuId(),s.getStuName(),s.getStuSex(),s.getStuAge(),s.getStuAddress()});
        return count>0?true:false;
    }

    public boolean update(Student s)throws SQLException{
        QueryRunner queryRunner=getQueryRunner();
        String sql="update student set stuName=?,stuSex=?,stuAge=?,stuAddress=? where stuId=?";
        int count=queryRunner.update(sql,new Object[]{s.getStuName(),s.getStuSex(),s.getStuAge(),s.getStuAddress(),s.getStuId()});
        return count>0?true:false;
    }
}
