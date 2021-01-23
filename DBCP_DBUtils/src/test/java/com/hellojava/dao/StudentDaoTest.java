package com.hellojava.dao;

import com.hellojava.database.dao.StudentDao;
import com.hellojava.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoTest {
    private StudentDao studentDao=new StudentDao();
    @Test
    public void testLoadAll(){
        List<Student> studentList= null;
        try {
            studentList = studentDao.loadAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assert.assertEquals(43,studentList.size());
    }

    @Test
    public void testLoadById(){
        Student s=null;
        try{
            s=studentDao.loadById(25);
            System.out.println(s);
            Assert.assertEquals(25,s.getStuId());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        boolean bool= false;
        try {
            bool = studentDao.delete(25);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assert.assertEquals(true,bool);
    }

    @Test
    public void testUpdate(){
        Student s=new Student();
        s.setStuId(31);
        s.setStuName("周芷若");
        s.setStuSex("女");
        s.setStuAge(20);
        s.setStuAddress("天津");
        boolean bool= false;
        try {
            bool = studentDao.update(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assert.assertEquals(true,bool);
    }

    @Test
    public void testSave(){
        Student s=new Student();
        s.setStuId(50);
        s.setStuName("殷离");
        s.setStuSex("女");
        s.setStuAge(22);
        s.setStuAddress("北京");

        boolean bool= false;
        try {
            bool = studentDao.save(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assert.assertEquals(true,bool);
    }
}
