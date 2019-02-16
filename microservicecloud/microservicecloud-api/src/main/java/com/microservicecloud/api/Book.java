package com.microservicecloud.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Book implements Serializable{
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String bookInfo;
}
