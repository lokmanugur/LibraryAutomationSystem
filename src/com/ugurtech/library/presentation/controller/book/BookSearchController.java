/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.book;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.book.BookForm;
import com.ugurtech.library.presentation.view.book.BookSearchForm;
import com.ugurtech.library.presentation.view.borrow.StartBorrowForm;
import java.util.Vector;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 *
 */
public final class BookSearchController extends BookController implements Initialize {

    private final BookSearchForm bookSearchForm;

    public BookSearchController(BookSearchForm bookSearchForm) {
        this.bookSearchForm = bookSearchForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {
        bookSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        bookSearchForm.getButtonWriteFile().addActionListener((java.awt.event.ActionEvent evt) -> {
            write();
        });

        bookSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });

        bookSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        bookSearchForm.getButtonAdd().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
        });
        bookSearchForm.getButtonSearch().addActionListener((java.awt.event.ActionEvent evt) -> {
            search();
        });
        bookSearchForm.getButtonBorrow().addActionListener((java.awt.event.ActionEvent evt) -> {
            addBasket();
        });
    }

    protected void add() {
        MainForm.INSTANCE.addDesktopPane(BookForm.getInstance());
    }

    protected void update() {
        if (updateUnSelectRowMessage(bookSearchForm.getBooksTable().getSelectedRow())) {
            MainForm.INSTANCE.addDesktopPane(BookForm.getInstance());
            BookForm.getInstance().setBookModel(get((Integer) (bookSearchForm.getBooksTable().getModel().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 0))));
            BookForm.getInstance().getBookFormController().modelToForm();
        }
    }

    protected void delete() {
        if (deleteApproveMessage(bookSearchForm.getBooksTable().getSelectedRow())) {
            delete((Integer) (bookSearchForm.getBooksTable().getModel().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 0)));
        }
        search();
    }

    public void search() {
        bookSearchForm.getBooksTable().setModel(
                search(bookSearchForm.getTextFieldSearch().getText(),
                        bookSearchForm.getComboBoxDate().getSelectedIndex(),
                        bookSearchForm.getDateChooserFirst().getDate() == null ? 0 : bookSearchForm.getDateChooserFirst().getDate().getTime(),
                        bookSearchForm.getDateChooserLast().getDate() == null ? 0 : bookSearchForm.getDateChooserLast().getDate().getTime()));
    }

    private void fillDateColumnToSelectionComboBox() {
        bookSearchForm.getComboBoxDate().removeAll();
        bookSearchForm.getComboBoxDate().addItem("");
        bookSearchForm.getComboBoxDate().addItem(setLanguage("book.publishdate"));
        bookSearchForm.getComboBoxDate().addItem(setLanguage("book.lastupdate"));
    }

    private void write() {
        write(bookSearchForm.getBooksTable(), bookSearchForm.getTitle());
    }

    private void setLanguage() {
        fillDateColumnToSelectionComboBox();
        bookSearchForm.getLabelColumn().setText(setLanguage("table.label.column"));
        bookSearchForm.getLabelStart().setText(setLanguage("table.begin.date"));
        bookSearchForm.getLabelEnd().setText(setLanguage("table.end.date"));
        bookSearchForm.getLabelSearch().setText(setLanguage("table.search"));
        bookSearchForm.getButtonAdd().setText(setLanguage("table.button.add"));
        bookSearchForm.getButtonBorrow().setText(setLanguage("book.search.form.button.add.basket"));
        bookSearchForm.getButtonDelete().setText(setLanguage("table.button.delete"));
        bookSearchForm.getButtonSearch().setText(setLanguage("table.search"));
        bookSearchForm.getButtonUpdate().setText(setLanguage("table.button.update"));
        bookSearchForm.getButtonWriteFile().setText(setLanguage("table.button.write.excel"));
        
    }
    
        private void addBasket() {
            int selectedRow =bookSearchForm.getBooksTable().getSelectedRow();
        if(unSelectRowMessage(selectedRow)){
            startBorrowForm().getStartBorrowFormController().addHashMap(
                (long)bookSearchForm.getBooksTable().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 1),
                addVector(), 
                (int) bookSearchForm.getBooksTable().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 8));
        }
    }

    private StartBorrowForm startBorrowForm() {
        StartBorrowForm startBorrowForm = StartBorrowForm.INSTANCE;
        if (!startBorrowForm.isVisible()) {
            MainForm.INSTANCE.addDesktopPane(startBorrowForm);
            startBorrowForm.setVisible(false);
        }
        return startBorrowForm;
    }

    private Vector<Object> addVector() {
        Vector<Object> dataList = new Vector<>();
        dataList.add(bookSearchForm.getBooksTable().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 0));
        dataList.add(bookSearchForm.getBooksTable().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 1));
        dataList.add(bookSearchForm.getBooksTable().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 2));
        dataList.add(1);
        return dataList;
    }
}
