/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.booktype;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.booktype.BookTypeForm;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.presentation.view.booktype.BookTypeSearchForm;

/**
 *
 * @author ugur
 * 
 */
public final class BookTypeSearchFormController extends BookTypeController implements Initialize {

    private final BookTypeSearchForm bookTypeSearchForm;

    public BookTypeSearchFormController(BookTypeSearchForm bookTypeForm) {
        this.bookTypeSearchForm = bookTypeForm;
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
        bookTypeSearchForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
            clearAllFields();
        });
        bookTypeSearchForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {

        });
        bookTypeSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        bookTypeSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
            clearAllFields();
        });
        bookTypeSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });
    }

    public void search() {
        bookTypeSearchForm.getTableBooksType().setModel(search(bookTypeSearchForm.getTextFieldSearch().getText()));
    }

    protected void add() {
        MainForm.getInstance().addDesktopPane(BookTypeForm.INSTANCE);
    }

    protected void update() {
        bookTypeModel = new BookTypeModel();
        if (bookTypeSearchForm.getTableBooksType().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            MainForm.getInstance().addDesktopPane(BookTypeForm.INSTANCE);
            BookTypeForm.INSTANCE.setBookTypeModel(get((int) bookTypeSearchForm.getTableBooksType().getModel().getValueAt(bookTypeSearchForm.getTableBooksType().getSelectedRow(), 0)));
            BookTypeForm.INSTANCE.getBookTypeFormController().modelToForm();
        }
    }

    protected void delete() {
        if (bookTypeSearchForm.getTableBooksType().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((Integer) (bookTypeSearchForm.getTableBooksType().getModel().getValueAt(bookTypeSearchForm.getTableBooksType().getSelectedRow(), 0)));

        }
        search();

    }

    public void clearAllFields() {
        bookTypeSearchForm.getTextFieldSearch().setText("");
    }

    private void setLanguage() {
        bookTypeSearchForm.setTitle(setLanguage("booktypeform.title"));
        bookTypeSearchForm.getLabelSearch().setText(setLanguage("table.label.search"));
        bookTypeSearchForm.getButtonSave().setText(setLanguage("table.button.add"));
        bookTypeSearchForm.getButtonWrite().setText(setLanguage("table.button.write.excel"));
        bookTypeSearchForm.getButtonUpdate().setText(setLanguage("table.button.update"));
        bookTypeSearchForm.getButtonDelete().setText(setLanguage("table.button.delete"));
    }
}
