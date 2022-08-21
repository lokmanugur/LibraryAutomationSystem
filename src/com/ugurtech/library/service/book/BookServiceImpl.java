/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.book;

import com.ugurtech.library.modelv2.BookModel;
import com.ugurtech.library.persistancev2.book.BookDao;
import java.util.List;

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
    public void delete(BookModel v) {
       bookDao.delete(v);
    }
    
}
