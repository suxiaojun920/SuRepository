package com.hellojava.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="person")
public class Person implements Serializable{
	@Id
	@GeneratedValue(generator="native")
	@GenericGenerator(name="native",strategy="foreign",parameters= {@Parameter(name="property",value="card")})
	private int personId;
	@Column(name="personName",length=20)
	private String personName;
	@OneToOne(optional=false)
//	@JoinColumn(name="cardId",unique=true)
	@PrimaryKeyJoinColumn
	private Card card;
	
}
