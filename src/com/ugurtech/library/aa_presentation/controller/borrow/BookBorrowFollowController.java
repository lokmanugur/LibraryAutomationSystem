/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.borrow;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.borrow.BookBorrowFollowForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 * 
 */
public final class BookBorrowFollowController extends AbstractController implements Initialize{
    
    private final BookBorrowFollowForm bookBorrowFollowForm;
    
    public BookBorrowFollowController(BookBorrowFollowForm bookBorrowFollowForm) {
        this.bookBorrowFollowForm = bookBorrowFollowForm;
        fillAllBorrowedBooks();
        initView();
        initController();
    }
    
    public final void fillAllBorrowedBooks(){
        Map<String,String> filters = new HashMap<>();
        Optional.ofNullable(bookBorrowFollowForm.getSearchTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("search", value));
        Optional.ofNullable(bookBorrowFollowForm.getSearchComboBox().getSelectedItem().toString())
                .ifPresent(value ->filters.put("allBooks", value));
        bookBorrowFollowForm.getBooksTable().setModel(DbUtils.resultSetToTableModel(null));
    }

    @Override
    public void initView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
