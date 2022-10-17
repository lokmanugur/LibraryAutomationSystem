/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.borrow;

import com.ugurtech.library.ac_dataaccesslayer.borrow.BorrowDao;
import com.ugurtech.library.ac_dataaccesslayer.borrow.BorrowDaoImpl;
import com.ugurtech.library.ad_model.PersonBookModel;
import java.util.List;
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
    public TableModel search(int dateId, long startDate, long endDate,int optionsId, String searchText) {
        return borrowDao.search(dateId, startDate, endDate,optionsId, searchText);
    }

    @Override
    public void add(PersonBookModel personBookModel) {
        this.borrowDao.add(personBookModel);
    }

    @Override
    public List<PersonBookModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonBookModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PersonBookModel v) {
        this.borrowDao.update(v);
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
