/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.borrow;

import com.ugurtech.library.dataaccesslayer.Dao;
import com.ugurtech.library.model.PersonBookModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BorrowDao {
    public TableModel search(int dateId,long startDate,long endDate,int optionsId,String searchText);
}
