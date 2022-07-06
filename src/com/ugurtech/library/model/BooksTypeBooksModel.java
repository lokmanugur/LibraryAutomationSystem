/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

/**
 *
 * @author ugur
 */
public class BooksTypeBooksModel extends DateModel {

    private int bookTypeBookId;
    private int bookTypeId;
    private int bookId;

    public int getBookTypeBookId() {
        return bookTypeBookId;
    }

    public void setBookTypeBookId(int bookTypeBookId) {
        this.bookTypeBookId = bookTypeBookId;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
   
}
