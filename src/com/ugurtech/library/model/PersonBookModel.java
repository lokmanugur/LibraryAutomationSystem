/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

import java.util.List;

/**
 *
 * @author ugur
 * 
 * 
 */
public class PersonBookModel {
    
    private int personBookId;
    private List<BookModel> bookModel;
    private StudentModel studentModel;
    private int readPage;
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

    public List<BookModel> getBookModel() {
        return bookModel;
    }

    public void setBookModel(List<BookModel> bookModel) {
        this.bookModel = bookModel;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
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

    public int getReadPage() {
        return readPage;
    }

    public void setReadPage(int readPage) {
        this.readPage = readPage;
    }
    
    
}
