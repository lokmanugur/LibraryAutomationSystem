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
 * 
 * 
 */
public class PersonBookModel {
    
    private int personBookId;
    private List<BookBorrowModel> bookBorrowModel;
    private int personId;
    private long startDate;
    private long deadLine;
    private long finishDate;
    private int amount;

    public int getPersonBookId() {
        return personBookId;
    }

    public void setPersonBookId(int personBookId) {
        this.personBookId = personBookId;
    }

    public List<BookBorrowModel> getBookBorrowModel() {
        return bookBorrowModel;
    }

    public void setBookBorrowModel(List<BookBorrowModel> bookBorrowModel) {
        this.bookBorrowModel = bookBorrowModel;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(long deadLine) {
        this.deadLine = deadLine;
    }

    public long getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(long finishDate) {
        this.finishDate = finishDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
