/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.book;

import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.service.Service;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BookService extends Service<BookModel>{

    public TableModel search(String text,int sellectedIndex,long firstDateLong,long lastDateLong);
    public BookModel getUpdate(int id);
}
