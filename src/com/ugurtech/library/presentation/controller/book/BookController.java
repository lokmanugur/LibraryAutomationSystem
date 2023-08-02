/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.book;

import com.ugurtech.library.service.author.AuthorService;
import com.ugurtech.library.service.author.AuthorServiceImpl;
import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.service.book.BookService;
import com.ugurtech.library.service.book.BookServiceImpl;
import com.ugurtech.library.service.booktype.BookTypeService;
import com.ugurtech.library.service.booktype.BookTypeServiceImpl;
import com.ugurtech.library.service.publisher.PublisherService;
import com.ugurtech.library.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.dataaccesslayer.author.AuthorDaoImpl;
import com.ugurtech.library.dataaccesslayer.book.BookDaoImpl;
import com.ugurtech.library.dataaccesslayer.booktype.BookTypeDaoImpl;
import com.ugurtech.library.dataaccesslayer.publisher.PublisherDaoImpl;
import com.ugurtech.library.model.BookModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookController extends AbstractController implements Controller<BookModel> {

    private final BookService bookService = new BookServiceImpl(new BookDaoImpl());
    protected final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    protected final BookTypeService bookTypeService = new BookTypeServiceImpl(new BookTypeDaoImpl());
    protected final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());
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
