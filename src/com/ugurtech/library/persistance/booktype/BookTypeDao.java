/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.booktype;

import com.ugurtech.library.model.BookTypeModel;
import java.sql.ResultSet;

/**
 *
 * @author ugur
 */
public interface BookTypeDao {
    
    public ResultSet findBookTypeByFilter();
    public BookTypeModel getBookType(int bookTypeId);
    public void addBookType(BookTypeModel bookTypeModel);
    public void updateBookType(BookTypeModel bookTypeModel);
    public void deleteBookType(int bookTypeId);
    
}
