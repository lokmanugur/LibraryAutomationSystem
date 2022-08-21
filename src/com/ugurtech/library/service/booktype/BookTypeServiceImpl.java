/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.booktype;

import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.persistancev2.booktype.BookTypeDao;
import java.sql.ResultSet;
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
       return bookTypeDao.get(id);
    }

    @Override
    public void add(BookTypeModel v) {
        bookTypeDao.add(v);
    }

    @Override
    public void update(BookTypeModel v) {
        bookTypeDao.update(v);
    }

    @Override
    public void delete(BookTypeModel v) {
        bookTypeDao.delete(v);
    }

    @Override
    public ResultSet search(String text) {
       return bookTypeDao.search(text);
    }
    
}
