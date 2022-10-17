/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.borrow;

import com.ugurtech.library.ab_application.service.Service;
import com.ugurtech.library.ad_model.PersonBookModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BorrowService extends Service<PersonBookModel>{
    public TableModel search(int dateId,long startDate,long endDate,int optionsId,String searchText);
}
