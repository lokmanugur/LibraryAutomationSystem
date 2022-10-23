/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.booktype;

import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.dataaccesslayer.Dao;
import java.sql.ResultSet;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BookTypeDao extends Dao<BookTypeModel> {

    public TableModel search(String text);
    
}
