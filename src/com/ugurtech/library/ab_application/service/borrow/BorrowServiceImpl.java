/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.borrow;

import com.ugurtech.library.ac_dataaccesslayer.borrow.BorrowDao;
import com.ugurtech.library.ac_dataaccesslayer.borrow.BorrowDaoImpl;
import com.ugurtech.library.ad_model.PersonBookModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BorrowServiceImpl implements BorrowService{

    private final BorrowDao borrowDao;
    public BorrowServiceImpl(BorrowDaoImpl borrowDaoImpl) {
        this.borrowDao=borrowDaoImpl;
    }

    @Override
    public TableModel search(int dateId, long startDate, long endDate, String searchText) {
        return borrowDao.search(dateId, startDate, endDate, searchText);
    }

    @Override
    public void add(PersonBookModel personBookModel) {
        this.borrowDao.add(personBookModel);
    }
    
}
