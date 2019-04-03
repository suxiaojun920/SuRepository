package com.hellojava.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stuId;
	@Column
	private String stuName;
	
	@ManyToMany(fetch = FetchType.LAZY,targetEntity = Teacher.class,cascade = CascadeType.ALL)
	@JoinTable(name = "student_teacher_mapping",
	joinColumns = @JoinColumn(name="sId",referencedColumnName = "stuId"),
	inverseJoinColumns = @JoinColumn(name="tId",referencedColumnName = "teacherId"))
	private Set<Teacher> teachers=new HashSet<Teacher>();
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
}
