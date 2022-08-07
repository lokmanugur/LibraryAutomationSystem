/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.view.book.BookForm;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.model.PublisherModel;
import com.ugurtech.library.persistance.book.BookDao;
import com.ugurtech.library.persistance.book.BookDaoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ugur
 */
public final class BookFormController {
    
    private final BookForm bookForm;
    private final BookDao bookDao;
    private BookModel bookModel;
    private List<BookTypeModel> bookTypeModel;
    private List<AuthorModel> authorModel;
    private List<PublisherModel> publisherModel;
    
    public BookFormController(BookForm booksForm){
        
        this.bookDao = new BookDaoImpl();
        this.bookForm = booksForm;
        this.bookTypeModel = new ArrayList<>();
        this.authorModel = new ArrayList<>();
        this.publisherModel = new ArrayList<>();
    }
    
    public void addBooks(){
        this.bookModel = new BookModel();
        List<AuthorModel> authorList = new ArrayList<>();
        List<BookTypeModel> bookTypeList = new ArrayList<>();
        bookModel.setIsbn(Long.parseLong(bookForm.getIsbnTextField().getText()));
        bookModel.setBookName(bookForm.getBookNameTextField().getText());
        bookModel.setPressDate(bookForm.getPressDateChooser().getDate()==null?null:bookForm.getPressDateChooser().getDate().getTime());
        
        for(int i=0;i<bookForm.getBooksTypeDefaultListModel().getSize();i++){
            bookTypeList.add((BookTypeModel)bookForm.getBooksTypeDefaultListModel().getElementAt(i));
        }
        bookModel.setBooksType(bookTypeList);
        
        for(int i=0;i<bookForm.getAuthorDefaultModel().getSize();i++){
            authorList.add((AuthorModel)bookForm.getAuthorDefaultModel().getElementAt(i));
        }
        bookModel.setAuthor(authorList);
        
        publisherModel.stream()
                .filter(pm -> (bookForm.getPublicsherComboBox().getSelectedItem().toString().equals(pm.getPublisherName())))
                .forEachOrdered(pm -> {bookModel.setPublisherId(pm.getPublisherId());});
        
        this.bookDao.addBook(bookModel);
    }
    
    public void allBooksType(){
        bookForm.getBooksTypeComboBox().removeAllItems();
        bookTypeModel.clear();
        bookTypeModel = bookDao.getAllBooksType();
        bookTypeModel.forEach(btm -> {
           // bookForm.getBooksTypeComboBox().addItem(btm.getTypeName());
        });
    }
    
    public void addFromBooksTypeComboBoxToBooksTypeList(){ 
        bookTypeModel.stream()
                .filter(btm -> (btm.getTypeName().equals(bookForm.getBooksTypeComboBox().getSelectedItem())))
                .forEachOrdered(btm -> {bookForm.getBooksTypeDefaultListModel().addElement(btm);});       
    }
    
    public void removeBooksTypeFromBooksTypeList(){
        if(!bookForm.getBookTypeList().isSelectionEmpty()){
        bookForm.getBooksTypeDefaultListModel().remove(bookForm.getBookTypeList().getSelectedIndex());}
    }
    
    public void allAuthors(){
        bookForm.getAuthorComboBox().removeAllItems();
        authorModel.clear();
        authorModel = bookDao.allAuthors();
        //authorModel.forEach(am -> {bookForm.getAuthorComboBox().addItem(am.getFirstName()+" "+am.getLastName());});
    }
    
    public void addFromAuthorComboBaxToAuthorList(){
        authorModel.stream()
                .filter(am -> ((am.getFirstName()+" "+am.getLastName()).equals(bookForm.getAuthorComboBox().getSelectedItem())))
                .forEachOrdered(am -> {bookForm.getAuthorDefaultModel().addElement(am);});
    }
    
    public void removeAuthorFromAuthorList(){
        if(!bookForm.getAuthorTypeList().isSelectionEmpty()){
        bookForm.getAuthorDefaultModel().remove(bookForm.getAuthorTypeList().getSelectedIndex());
        }
    }
    
    public void allPublisher(){
        bookForm.getPublicsherComboBox().removeAllItems();
        publisherModel.clear();
        publisherModel = bookDao.allPublisher();
       // publisherModel.forEach(pm->{bookForm.getPublicsherComboBox().addItem(pm);});
    }
}
