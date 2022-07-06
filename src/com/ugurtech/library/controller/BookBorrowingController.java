/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.personbook.PersonBookDao;
import com.ugurtech.library.persistance.personbook.PersonBookDaoImpl;
import com.ugurtech.library.model.BookBorrowingModel;
import com.ugurtech.library.model.PersonBookBorrowingModel;
import com.ugurtech.library.model.PersonBookModel;
import com.ugurtech.library.view.bookborrowing.BookBorrowingForm;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ugur
 * 
 */
public class BookBorrowingController {
    private final BookBorrowingForm bookBorrowing;
    private final PersonBookDao personBookDao;
    private List<PersonBookBorrowingModel> personBookBorrowingList;
    private List<BookBorrowingModel> bookBorrowingList;
    private PersonBookModel personBookModel;
    
    public BookBorrowingController(BookBorrowingForm bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
        personBookDao = new PersonBookDaoImpl();
    }
    
    public void addPersonBook(){
        personBookModel = new PersonBookModel();
        List<BookBorrowingModel> bookBorrowingModelList = new ArrayList<>();
        personBookBorrowingList.stream()
                .filter(value -> (bookBorrowing.getPersonComboBox().getSelectedItem().equals(value.toString())))
                .forEachOrdered(value -> {personBookModel.setPersonId(value.getPersonId());});
        for(int i=0;i<bookBorrowing.getDefaultListModel().getSize();i++){
            bookBorrowingModelList.add((BookBorrowingModel)bookBorrowing.getDefaultListModel().getElementAt(i));
        }
        personBookModel.setBookBorrowingModel(bookBorrowingModelList);
        personBookModel.setStartDate(bookBorrowing.getIssueDateChooser().getDate()==null?null:new Date(bookBorrowing.getIssueDateChooser().getDate().getTime()));
        personBookModel.setFinishDate(bookBorrowing.getDueDateChooser().getDate()==null?null:new Date(bookBorrowing.getDueDateChooser().getDate().getTime()));
        personBookDao.addPersonBook(personBookModel);
    }
    
    public void addAllPersonToPersonComboBox(){
        personBookBorrowingList = personBookDao.getAllPerson();
        bookBorrowing.getPersonComboBox().removeAllItems();
        personBookBorrowingList.forEach(value -> {bookBorrowing.getPersonComboBox().addItem(value.toString());});
    }
    
    public void addAllBookToIsbnComboBox(){
        bookBorrowingList = personBookDao.getAllBook();
        bookBorrowing.getISBNComboBox().removeAllItems();
        bookBorrowingList.forEach(value -> {bookBorrowing.getISBNComboBox().addItem(String.valueOf(value.getIsbn()));});
    }
    
    public void personComboBoxSelectedItem(){
        personBookBorrowingList.stream()
        .filter(value -> (bookBorrowing.getPersonComboBox().getSelectedItem().equals(value.toString())))
        .map(value -> {bookBorrowing.getStudentNumberTextField().setText(value.getStudentNumber()); return value;})
        .map(value -> {bookBorrowing.getClassRoomTextField().setText(value.getStudentClass()); return value;})
        .map(value -> {bookBorrowing.getSchoolNameTextField().setText(value.getSchool()); return value;})
        .map(value -> {bookBorrowing.getPhoneTextField().setText(value.getPhone()); return value;})
        .forEachOrdered(value -> {bookBorrowing.getAddressTextArea().setText(value.getAddress());});
    }
    
    public void isbnSelectedItem(){
        bookBorrowingList.stream().filter(value -> (bookBorrowing.getISBNComboBox().getSelectedItem().equals(String.valueOf(value.getIsbn()))))
          .map(value -> {bookBorrowing.getBookTitleTextField().setText(value.getBookName()); return value;})
          .map(value -> {bookBorrowing.getAuthorTextField().setText(value.getBookAutors()); return value;})
          .forEachOrdered(value -> {bookBorrowing.getBookTypeTextField().setText(value.getBookTypes());});
    }
    
    public void addBooktoBorrowingBookList(){
        bookBorrowingList.stream()
                .filter(value -> (bookBorrowing.getISBNComboBox().getSelectedItem().equals(String.valueOf(value.getIsbn()))))
                .forEachOrdered(value -> {bookBorrowing.getDefaultListModel().addElement(value);});
    }
    
    public void removeBookFromBorrowingBooksList(){
        if(!bookBorrowing.getTakenBookList().isSelectionEmpty()){
        bookBorrowing.getDefaultListModel().remove(bookBorrowing.getTakenBookList().getSelectedIndex());}
    }
     
}