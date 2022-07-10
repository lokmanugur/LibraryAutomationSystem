/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.borrowedbook.BorrowedBookDao;
import com.ugurtech.library.persistance.borrowedbook.BorrowedBookDaoImpl;
import com.ugurtech.library.view.bookborrowing.BorrowedBooksTable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 * 
 */
public final class BorrowedBookTableController {
    
    private final BorrowedBooksTable borrowedBooksTable;
    private final BorrowedBookDao borrowedBookDao;
    
    public BorrowedBookTableController(BorrowedBooksTable borrowedBooksTable) {
        this.borrowedBooksTable = borrowedBooksTable;
        this.borrowedBookDao=new BorrowedBookDaoImpl();
        fillAllBorrowedBooks();
    }
    
    public void fillAllBorrowedBooks(){
        Map<String,String> filters = new HashMap<>();
        Optional.ofNullable(borrowedBooksTable.getSearchTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("search", value));
        Optional.ofNullable(borrowedBooksTable.getSearchComboBox().getSelectedItem().toString())
                .ifPresent(value ->filters.put("allBooks", value));
        borrowedBooksTable.getBooksTable().setModel(DbUtils.resultSetToTableModel(borrowedBookDao.filtersAllBorrowedBooks(filters)));
    }
}
