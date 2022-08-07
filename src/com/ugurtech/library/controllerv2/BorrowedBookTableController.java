/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

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
public class BorrowedBookTableController extends AbstractController {
    
    private final BorrowedBooksTable borrowedBooksTable;
    private final BorrowedBookDao borrowedBookDao;
    
    public BorrowedBookTableController(BorrowedBooksTable borrowedBooksTable) {
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
    public final void initView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public final void initController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
