/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.book;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.MainForm;
import com.ugurtech.library.aa_presentation.view.book.BookForm;
import com.ugurtech.library.ab_application.af_lib.writetofile.TableToExcelImpl;
import com.ugurtech.library.aa_presentation.view.book.BookSearchForm;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;

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
        fillDateColumnToSelectionComboBox();
        setLanguage();
        search();
    }

    @Override
    public void initController() {
        bookSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        bookSearchForm.getButtonWriteFile().addActionListener((java.awt.event.ActionEvent evt) -> {
            new TableToExcelImpl(bookSearchForm.getBooksTable(), "Kitaplar Tablosu").writeToTable();
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
    }

    protected void add() {
        MainForm.getInstance().addDesktopPane(BookForm.getInstance());
    }

    protected void update() {
       MainForm.getInstance().addDesktopPane(BookForm.getInstance());
       BookForm.getInstance().setBookModel(getUpdate((Integer) (bookSearchForm.getBooksTable().getModel().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 0))));
       BookForm.getInstance().getBookFormController().modelToForm();
    }

    protected void delete() {
        if (bookSearchForm.getBooksTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((Integer) (bookSearchForm.getBooksTable().getModel().getValueAt(bookSearchForm.getBooksTable().getSelectedRow(), 0)));

        }
        search();
    }

    private void search() {
        bookSearchForm.getBooksTable().setModel(
                search(bookSearchForm.getTextFieldSearch().getText(),
                        bookSearchForm.getComboBoxDate().getSelectedIndex(),
                        bookSearchForm.getDateChooserFirst().getDate() == null ? 0 : bookSearchForm.getDateChooserFirst().getDate().getTime(),
                        bookSearchForm.getDateChooserLast().getDate() == null ? 0 : bookSearchForm.getDateChooserLast().getDate().getTime()));
    }

    private void setLanguage() {

    }

    private void fillDateColumnToSelectionComboBox() {
        bookSearchForm.getComboBoxDate().removeAll();
        bookSearchForm.getComboBoxDate().addItem("");
        bookSearchForm.getComboBoxDate().addItem(setLanguage("book.publishdate"));
        bookSearchForm.getComboBoxDate().addItem(setLanguage("book.lastupdate"));
    }
}
