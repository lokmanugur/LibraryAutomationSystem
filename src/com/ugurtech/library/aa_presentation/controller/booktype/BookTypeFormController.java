/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.booktype;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.booktype.BookTypeForm;
import com.ugurtech.library.aa_presentation.view.booktype.BookTypeSearchForm;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ad_model.BookTypeModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public final class BookTypeFormController extends BookTypeController implements Initialize {

    private final BookTypeForm bookTypeForm;

    public BookTypeFormController(BookTypeForm bookTypeForm) {
        this.bookTypeForm = bookTypeForm;
        initView();
        initController();
    }

    private void setLanguage() {
        bookTypeForm.setTitle(setLanguage("booktypeform.title"));
        bookTypeForm.getLabelBookTypeName().setText(setLanguage("booktypeform.panelbooktype.labelbookname"));
        bookTypeForm.getLabelAbbreviation().setText(setLanguage("booktypeform.panelbooktype.labelabbreviation"));
    }

    private void add() {
        add(formToModel());
        BookTypeSearchForm.getInstance().getBookTypeSearchFormController().initView();
    }

    @Override
    public void initView() {
        setLanguage();
    }

    @Override
    public void initController() {
        bookTypeForm.getButtonSave().addActionListener(((e) -> {
            if (bookTypeForm.getBookTypeModel() != null) {
                updete();
                bookTypeForm.setBookTypeModel(null);
                clearFields();
            } else {
                add();
                clearFields();
            }
        }));
        bookTypeForm.getButtonCancel().addActionListener(((e) -> {
            bookTypeForm.setBookTypeModel(null);
            clearFields();
            bookTypeForm.dispose();
        }));
    }

    private void updete() {
        update(formToModel());
        BookTypeSearchForm.getInstance().getBookTypeSearchFormController().initView();
    }

    private BookTypeModel formToModel() {
        BookTypeModel btm = null;
        if (bookTypeForm.getTextFieldBookTypeName().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("booktypecontroller.booktypefield.empty"));
        } else {
            btm = new BookTypeModel();
            btm.setBookTypeId(bookTypeForm.getBookTypeModel()==null?0:bookTypeForm.getBookTypeModel().getBookTypeId());
            btm.setTypeName(bookTypeForm.getTextFieldBookTypeName().getText());
            btm.setAbbrivation(bookTypeForm.getTextFieldAbbreviation().getText());
        }
        return btm;
    }

    public void modelToForm() {
        bookTypeForm.getTextFieldBookTypeName().setText(bookTypeForm.getBookTypeModel().getTypeName());
        bookTypeForm.getTextFieldAbbreviation().setText(bookTypeForm.getBookTypeModel().getAbbrivation());
    }

    public void clearFields() {
        bookTypeForm.getTextFieldBookTypeName().setText("");
        bookTypeForm.getTextFieldAbbreviation().setText("");
    }
}
