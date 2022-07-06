/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.book;

import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.model.PublisherModel;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ugur
 * 
 */
public interface BookDao {
    public ResultSet findBooksByFilters(Map<String, String> filters);
    public BookModel getBook(int bookId);
    public void addBook(BookModel book);
    public void updateBook(BookModel book);
    public void deleteBook(int bookid);
    public List<BookTypeModel>  getAllBooksType();
    public List<AuthorModel> allAuthors();
    public List<PublisherModel> allPublisher();
}
