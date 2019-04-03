package com.hellojava.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table
public class Person implements Serializable{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
	@Column
    private String bookName;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "address")
	@MapKeyColumn(name = "M_KEY")
	private Map<String,String> address=new HashMap<String,String>();
	
	
	public Map<String,String> getAddress() {
		return address;
	}
	public void setAddress(Map<String,String> address) {
		this.address = address;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "Person [bookId=" + bookId + ", bookName=" + bookName + ", address=" + address + "]";
	}
}
