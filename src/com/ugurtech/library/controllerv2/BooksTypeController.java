/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.persistancev2.booktype.BookTypeDaoImpl;
import com.ugurtech.library.service.booktype.BookTypeService;
import com.ugurtech.library.service.booktype.BookTypeServiceImpl;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.view.booktype.BookTypeForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 */
public final class BooksTypeController extends AbstractController {

    private final BookTypeForm bookTypeForm;
    private final BookTypeService bookTypeService = new BookTypeServiceImpl(new BookTypeDaoImpl());
    private BookTypeModel bookTypeModel;

    public BooksTypeController(BookTypeForm bookTypeForm) {
        this.bookTypeForm = bookTypeForm;
        initView();
        initController();
    }

    @Override
    void initView() {
        setLanguage();
        search();
    }

    @Override
    void initController() {
        bookTypeForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
            clearAllFields();
        });
        bookTypeForm.getButtonCancel().addActionListener((java.awt.event.ActionEvent evt) -> {
            clearAllFields();
            bookTypeForm.dispose();
        });
        bookTypeForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
            clearAllFields();
        });

        bookTypeForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
            clearAllFields();
        });
        bookTypeForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });
    }

    public void search() {
        bookTypeForm.getTableBooksType().setModel(DbUtils.resultSetToTableModel(bookTypeService.search(bookTypeForm.getTextFieldSearch().getText())));
    }

    @Override
    void add() {
                bookTypeModel = new BookTypeModel();
        if (bookTypeForm.getTextFieldBookTypeName().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("booktypecontroller.booktypefield.empty"));
        } else {
            bookTypeModel.setTypeName(bookTypeForm.getTextFieldBookTypeName().getText());
            bookTypeModel.setAbbrivation(bookTypeForm.getTextFieldAbbreviation().getText());
            bookTypeService.add(bookTypeModel);
        }
        clearAllFields();
        search();
    }

    @Override
    void update() {
            bookTypeModel = new BookTypeModel();
        if (bookTypeForm.getTableBooksType().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            bookTypeModel.setBookTypeId((int)bookTypeForm.getTableBooksType().getModel().getValueAt(bookTypeForm.getTableBooksType().getSelectedRow(), 0));
            bookTypeModel.setTypeName((String) bookTypeForm.getTableBooksType().getModel().getValueAt(bookTypeForm.getTableBooksType().getSelectedRow(), 1));
            bookTypeModel.setAbbrivation((String) bookTypeForm.getTableBooksType().getModel().getValueAt(bookTypeForm.getTableBooksType().getSelectedRow(), 2));
           // bookTypeModel.setLastUpdate((Long)bookTypeForm.getTableBooksType().getModel().getValueAt(bookTypeForm.getTableBooksType().getSelectedRow(), 3));
            bookTypeService.update(bookTypeModel);
        }
        clearAllFields();
        search();
    }

    @Override
    void delete() {
        if (bookTypeForm.getTableBooksType().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            bookTypeService.delete(bookTypeService.get((Integer)(bookTypeForm.getTableBooksType().getModel().getValueAt(bookTypeForm.getTableBooksType().getSelectedRow(),0))));
            
        }
        search();
        
    }

    public void clearAllFields() {
        bookTypeForm.getTextFieldSearch().setText("");
        bookTypeForm.getTextFieldAbbreviation().setText("");
        bookTypeForm.getTextFieldBookTypeName().setText("");
    }

    private void setLanguage() {
        bookTypeForm.setTitle(setLanguage("booktypeform.title"));
        bookTypeForm.getLabelBookTypeName().setText(setLanguage("booktypeform.panelbooktype.labelbookname"));
        bookTypeForm.getLabelAbbreviation().setText(setLanguage("booktypeform.panelbooktype.labelabbreviation"));
        bookTypeForm.getLabelSearch().setText(setLanguage("booktypeform.panelbooktype.labelsearch"));
        bookTypeForm.getButtonSave().setText(setLanguage("booktypeform.panelbooktype.buttonsave"));
        bookTypeForm.getButtonCancel().setText(setLanguage("booktypeform.panelbooktype.buttoncancel"));
        bookTypeForm.getButtonUpdate().setText(setLanguage("booktypeform.panelbooktype.buttonupdate"));
        bookTypeForm.getButtonDelete().setText(setLanguage("booktypeform.panelbooktype.buttondelete"));
    }
}
