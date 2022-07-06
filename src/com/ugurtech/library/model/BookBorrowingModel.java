/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

/**
 * @author ugur
 * 
 */
public class BookBorrowingModel {
    private int bookId;
    private long isbn;
    private String bookName;
    private String bookAutors;
    private String bookTypes;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    
    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAutors() {
        return bookAutors;
    }

    public void setBookAutors(String bookAutors) {
        this.bookAutors = bookAutors;
    }

    public String getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(String bookTypes) {
        this.bookTypes = bookTypes;
    }

    @Override
    public String toString(){
        return String.valueOf(getBookId());
    }
}
