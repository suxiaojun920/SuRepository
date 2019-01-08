package com.hellojava.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class Book implements Serializable {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	public String bookInfo;
}
