/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.borrow;

import com.ugurtech.library.ad_model.PersonBookModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BorrowDao {
    public TableModel search(int dateId,long startDate,long endDate,String searchText);
    public void add(PersonBookModel personBookModel);
}
