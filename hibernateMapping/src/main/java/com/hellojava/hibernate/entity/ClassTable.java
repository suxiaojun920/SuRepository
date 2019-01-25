package com.hellojava.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="class")
public class ClassTable implements Serializable {
	@Id
	@GeneratedValue(generator="identity")
	@GenericGenerator(name="identity",strategy="native")
	private int classId;
	@Column(name="className",length=20)
	private String className;
}
