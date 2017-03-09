package com.yinrong.model;

import java.io.Serializable;

/**
 * @author yinrong
 * @className Book
 * @description ${description}
 * @date 2017/3/9
 */
public class Book implements Serializable {
    private String bookISBN;
    private String bookName;

    public Book(String bookISBN, String bookName) {
        this.bookISBN = bookISBN;
        this.bookName = bookName;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}