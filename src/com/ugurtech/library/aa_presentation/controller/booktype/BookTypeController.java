/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.booktype;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Controller;
import com.ugurtech.library.ab_application.service.booktype.BookTypeService;
import com.ugurtech.library.ab_application.service.booktype.BookTypeServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.booktype.BookTypeDaoImpl;
import com.ugurtech.library.ad_model.BookTypeModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookTypeController extends AbstractController implements Controller<BookTypeModel> {

    private final BookTypeService bookTypeService = new BookTypeServiceImpl(new BookTypeDaoImpl());
    public BookTypeModel bookTypeModel;

    @Override
    public List<BookTypeModel> getAll() {
        return bookTypeService.getAll();
    }

    @Override
    public BookTypeModel get(int id) {
        return bookTypeService.get(id);
    }

    @Override
    public void add(BookTypeModel v) {
        bookTypeService.add(v);
    }

    @Override
    public void update(BookTypeModel v) {
        bookTypeService.update(v);
    }

    @Override
    public void delete(int id) {
        bookTypeService.delete(id);
    }
    
    public TableModel search(String str){
        return bookTypeService.search(str);
    }

}
