/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.booktype;

import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.dataaccesslayer.booktype.BookTypeDao;
import java.util.List;
import javax.swing.table.TableModel;

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
    public void delete(int id) {
        bookTypeDao.delete(get(id));
    }

    @Override
    public TableModel search(String text) {
       return bookTypeDao.search(text);
    }
    
}
