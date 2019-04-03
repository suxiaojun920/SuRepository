package com.hellojava.entity;

import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table
public class ClassTable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	@Column
	private String className;
	//mappeby(是关系属性)
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,
			mappedBy = "ct",targetEntity = Student.class,orphanRemoval = true)
	private List<Student> stus=new ArrayList<Student>();
	
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
