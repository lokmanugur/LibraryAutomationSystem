/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.booktype;

import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.persistancev2.booktype.BookTypeDao;
import java.util.List;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookTypeServiceImpl implements BookTypeService{
    
    private final BookTypeDao bookTypeDao;

    public BookTypeServiceImpl(BookTypeDao bookTypeDao) {
        this.bookTypeDao = bookTypeDao;
    }

    @Override
    public List<BookTypeModel> getAll() {
       return bookTypeDao.getAll();
    }

    @Override
    public BookTypeModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(BookTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BookTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BookTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
