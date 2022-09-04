/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.book;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Controller;
import com.ugurtech.library.ab_application.service.book.BookService;
import com.ugurtech.library.ab_application.service.book.BookServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.book.BookDaoImpl;
import com.ugurtech.library.ad_model.BookModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookController extends AbstractController implements Controller<BookModel> {

    private final BookService bookService = new BookServiceImpl(new BookDaoImpl());
    protected BookModel bookModel;

    @Override
    public List<BookModel> getAll() {
        return bookService.getAll();
    }

    @Override
    public BookModel get(int id) {
        return bookService.get(id);
    }

    @Override
    public void add(BookModel v) {
        bookService.add(v);
    }

    @Override
    public void update(BookModel v) {
        bookService.update(v);
    }

    @Override
    public void delete(int id) {
        bookService.delete(id);
    }

    public TableModel search(String str, int selectedIndex, long firstDateLong, long lastDateLong) {
        return bookService.search(str, selectedIndex, firstDateLong, lastDateLong);
    }

    public BookModel getUpdate(int id) {
        return bookService.getUpdate(id);
    }
}
