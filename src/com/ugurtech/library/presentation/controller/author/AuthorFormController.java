/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.author;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.presentation.view.author.AuthorForm;
import java.util.Date;

/**
 *
 * @author ugur
 */
public final class AuthorFormController extends AuthorController implements Initialize {

    private final AuthorForm authorForm;

    public AuthorFormController(AuthorForm authorForm) {
        this.authorForm = authorForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
    }

    @Override
    public void initController() {
        authorForm.getCancelButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            clearAllFields();
            authorForm.setAuthorModel(null);
            authorForm.dispose();
        });

        authorForm.getSaveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            if(authorForm.getAuthorModel()==null){
                add();
            }else{
                update();
            }
            clearAllFields();
            authorForm.dispose();
        });
    }

    protected void add() {
        add(formToModel());
    }

    private void update() {
        update(formToModel());
        authorForm.setAuthorModel(null);
    }

    private AuthorModel formToModel() {
        if (authorForm.getTextFieldFirstName().getText().equals("") && authorForm.getTextFieldLastName().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("authorcontroller.add.leaveblank.caution"));
            return null;
        } else {
            int authorId = authorForm.getAuthorModel() == null ? 0 : authorForm.getAuthorModel().getAuthorId();
            authorModel = new AuthorModel();
            authorModel.setAuthorId(authorId);
            authorModel.setFirstName(authorForm.getTextFieldFirstName().getText());
            authorModel.setLastName(authorForm.getTextFieldLastName().getText());
            authorModel.setBirthDate(authorForm.getBirthDateChooser().getDateEditor().getDate() == null ? 0 : authorForm.getBirthDateChooser().getDateEditor().getDate().getTime());
            return authorModel;
        }
    }
    
    protected void modelToForm() {
        authorForm.getTextFieldFirstName().setText(authorForm.getAuthorModel().getFirstName());
        authorForm.getTextFieldLastName().setText(authorForm.getAuthorModel().getLastName());
        authorForm.getBirthDateChooser().setDate(new Date(authorForm.getAuthorModel().getBirthDate()));
    }

    private void clearAllFields() {
        authorForm.getTextFieldFirstName().setText(null);
        authorForm.getTextFieldLastName().setText(null);
        authorForm.getBirthDateChooser().setDate(null);
    }

    private void setLanguage() {
        authorForm.setTitle(setLanguage("authorform.title"));
        authorForm.getLabelFirstName().setText(setLanguage("authorform.panelsave.labelfirstname"));
        authorForm.getLabelLastName().setText(setLanguage("authorform.panelsave.labellastname"));
        authorForm.getLabelBirthDate().setText(setLanguage("authorform.panelsave.labelbirthdate"));
        authorForm.getSaveButton().setText(setLanguage("authorform.panelsave.savebutton"));
        authorForm.getCancelButton().setText(setLanguage("authorform.panelsave.cancelbutton"));
    }

}
