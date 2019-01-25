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
@Table(name="card")
public class Card implements Serializable {
	@Id
	@GeneratedValue(generator="native")
	@GenericGenerator(name="native",strategy="native")
	private int cardId;
	@Column(name="cardNumber",length=20)
	private String cardNumber;
}
