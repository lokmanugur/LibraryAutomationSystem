/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.borrowbook;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.persistance.borrowedbook.BorrowedBookDao;
import com.ugurtech.library.persistance.borrowedbook.BorrowedBookDaoImpl;
import com.ugurtech.library.aa_presentation.view.borrowbook.BookBorrowedDetailForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 * 
 */
public final class BorrowSearchFormController extends AbstractController implements Initialize{
    
    private final BookBorrowedDetailForm borrowedBooksTable;
    private final BorrowedBookDao borrowedBookDao;
    
    public BorrowSearchFormController(BookBorrowedDetailForm borrowedBooksTable) {
        this.borrowedBooksTable = borrowedBooksTable;
        this.borrowedBookDao=new BorrowedBookDaoImpl();
        fillAllBorrowedBooks();
        initView();
        initController();
    }
    
    public final void fillAllBorrowedBooks(){
        Map<String,String> filters = new HashMap<>();
        Optional.ofNullable(borrowedBooksTable.getSearchTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("search", value));
        Optional.ofNullable(borrowedBooksTable.getSearchComboBox().getSelectedItem().toString())
                .ifPresent(value ->filters.put("allBooks", value));
        borrowedBooksTable.getBooksTable().setModel(DbUtils.resultSetToTableModel(borrowedBookDao.filtersAllBorrowedBooks(filters)));
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