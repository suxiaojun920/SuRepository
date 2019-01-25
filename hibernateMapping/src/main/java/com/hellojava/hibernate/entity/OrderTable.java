package com.hellojava.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="orderTable")
public class OrderTable implements Serializable {
	@Id
	@GeneratedValue(generator="identity")
	@GenericGenerator(name="identity",strategy="native")
	private int orderId;
	@Column(name="orderName",length=20)
	private String orderName;
	@ManyToMany(targetEntity=Product.class)
	@JoinTable(name="order_product_mapping",
	joinColumns= {@JoinColumn(name="oId",referencedColumnName="orderId")},
	inverseJoinColumns= {@JoinColumn(name="pId",referencedColumnName="productId")}
)
	private Set<Product> products;
}
