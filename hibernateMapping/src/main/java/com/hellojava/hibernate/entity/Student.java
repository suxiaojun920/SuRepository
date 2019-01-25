package com.hellojava.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@Entity
@Table(name="student")
public class Student implements Serializable {
	@Id
	@GeneratedValue(generator="identity")
	@GenericGenerator(name="identity",strategy="native")
	private int stuId;
	@Column(name="stuName",length=20)
	private String stuName;
	@Column(name="stuSex",length=20)
	private String stuSex;
	@Column(name="stuAge")
	private int stuAge;
	@ManyToOne
	@JoinColumn(name="classId")
	private ClassTable classTable;
}
