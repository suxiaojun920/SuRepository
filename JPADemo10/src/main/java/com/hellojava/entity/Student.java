package com.hellojava.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = ClassTable.class)
	@JoinColumn(name = "cid",referencedColumnName = "classId")
	private ClassTable ct;
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
	public ClassTable getCt() {
		return ct;
	}
	public void setCt(ClassTable ct) {
		this.ct = ct;
	}
}
