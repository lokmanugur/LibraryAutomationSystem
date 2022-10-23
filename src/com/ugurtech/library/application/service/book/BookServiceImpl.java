/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.application.service.book;

import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.dataaccesslayer.book.BookDao;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookServiceImpl implements BookService{
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    @Override
    public List<BookModel> getAll() {
        return bookDao.getAll();
    }

    @Override
    public BookModel get(int id) {
        return bookDao.get(id);
    }

    @Override
    public void add(BookModel v) {
        bookDao.add(v);
    }

    @Override
    public void update(BookModel v) {
        bookDao.update(v);
    }

    @Override
    public void delete(int id) {
       bookDao.delete(get(id));
    }

    @Override
    public TableModel search(String srch,int selInd,long firstD,long lastD) {
      return bookDao.search(srch,selInd,firstD,lastD);
    }

    @Override
    public BookModel getUpdate(int id) {
       return null;//bookDao.getUpdate(id);
    }
    
}
