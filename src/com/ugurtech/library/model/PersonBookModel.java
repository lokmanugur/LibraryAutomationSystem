/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author ugur
 */
public class PersonBookModel {
    
    private int personBookId;
    private List<BookBorrowingModel> bookBorrowingModel;
    private int personId;
    private Date startDate;
    private Date finishDate;
    private Date bringBackDate;

    public int getPersonBookId() {
        return personBookId;
    }

    public void setPersonBookId(int personBookId) {
        this.personBookId = personBookId;
    }

    public List<BookBorrowingModel> getBookBorrowingModel() {
        return bookBorrowingModel;
    }

    public void setBookBorrowingModel(List<BookBorrowingModel> bookBorrowingModel) {
        this.bookBorrowingModel = bookBorrowingModel;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getBringBackDate() {
        return bringBackDate;
    }

    public void setBringBackDate(Date bringBackDate) {
        this.bringBackDate = bringBackDate;
    }
    
}
