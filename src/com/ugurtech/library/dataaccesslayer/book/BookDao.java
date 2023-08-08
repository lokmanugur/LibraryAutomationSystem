/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.book;

import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.dataaccesslayer.Dao;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BookDao{

    public TableModel search(String srch,int selInd,long firstD,long lastD);
    //public BookModel getUpdate(int id);
    
}
