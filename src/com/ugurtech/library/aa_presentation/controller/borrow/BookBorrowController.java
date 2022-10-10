/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.borrow;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.borrow.BookBorrowForm;
import com.ugurtech.library.aa_presentation.view.borrow.FinishBorrowedForm;
import com.ugurtech.library.aa_presentation.view.main.MainForm;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 *
 */
public final class BookBorrowController extends ControllerImpl implements Initialize {

    private final BookBorrowForm bookBorrowForm;

    public BookBorrowController(BookBorrowForm bookBorrowForm) {
        this.bookBorrowForm = bookBorrowForm;

        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
        fillDateColumnToSelectionComboBox();
        search();
    }

    @Override
    public void initController() {
        bookBorrowForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        bookBorrowForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {
            write();
        });

        bookBorrowForm.getButtonSearch().addActionListener((java.awt.event.ActionEvent evt) -> {
            search();
        });
        
        bookBorrowForm.getButtonReturn().addActionListener((e) -> {
            MainForm.getInstance().addDesktopPane(FinishBorrowedForm.INSTANCE);
        });
        
        bookBorrowForm.getComboBoxOptions().addItemListener((java.awt.event.ItemEvent evt) -> {
            search();
        });
    }

    public void search() {
        bookBorrowForm.getTableBooks().setModel(
                search(bookBorrowForm.getTextFieldSearch().getText(),
                        bookBorrowForm.getComboBoxOptions().getSelectedIndex(),
                        bookBorrowForm.getComboBoxDate().getSelectedIndex(),
                        bookBorrowForm.getDateChooserFirst().getDate() == null ? 0 : bookBorrowForm.getDateChooserFirst().getDate().getTime(),
                        bookBorrowForm.getDateChooserLast().getDate() == null ? 0 : bookBorrowForm.getDateChooserLast().getDate().getTime()));

    }

    private void write() {
        write(bookBorrowForm.getTableBooks(), bookBorrowForm.getTitle());
    }

    private void fillDateColumnToSelectionComboBox() {
        bookBorrowForm.getComboBoxDate().removeAll();
        bookBorrowForm.getComboBoxDate().addItem("");
        bookBorrowForm.getComboBoxDate().addItem(setLanguage("book.publishdate"));
        bookBorrowForm.getComboBoxDate().addItem(setLanguage("book.lastupdate"));
    }

    private void setLanguage() {
    }



}
