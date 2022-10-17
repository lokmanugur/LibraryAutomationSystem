/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ad_model;

import java.util.List;

/**
 *
 * @author ugur
 */
public class BookModel extends DateModel {
    private int bookId;
    private long isbn;
    private int sysuserId;
    private List<AuthorModel> author;
    private List<BookTypeModel> booksType;
    private PublisherModel publisherModel;
    private String bookName;
    private long pressDate;
    private int pageNumbber;
    private int quantity;
    private int stock;
    private String shelf;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(int sysuserId) {
        this.sysuserId = sysuserId;
    }

    public PublisherModel getPublisherModel() {
        return publisherModel;
    }

    public void setPublisherModel(PublisherModel publisherModel) {
        this.publisherModel = publisherModel;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getPressDate() {
        return pressDate;
    }

    public void setPressDate(long pressDate) {
        this.pressDate = pressDate;
    }

    public List<AuthorModel> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorModel> author) {
        this.author = author;
    }

    public List<BookTypeModel> getBookType() {
        return booksType;
    }

    public void setBooksType(List<BookTypeModel> booksType) {
        this.booksType = booksType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public int getPageNumbber() {
        return pageNumbber;
    }

    public void setPageNumbber(int pageNumbber) {
        this.pageNumbber = pageNumbber;
    }
    
}
