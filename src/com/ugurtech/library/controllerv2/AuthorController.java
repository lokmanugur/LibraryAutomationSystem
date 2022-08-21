/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.persistancev2.author.AuthorDaoImpl;
import com.ugurtech.library.service.author.AuthorService;
import com.ugurtech.library.service.author.AuthorServiceImpl;
import com.ugurtech.library.view.author.AuthorForm;

/**
 *
 * @author ugur
 */
public final class AuthorController extends AbstractController {

    private final AuthorForm authorForm;
    private AuthorModel authorModel;
    private final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());

    public AuthorController(AuthorForm authorForm) {
        this.authorForm = authorForm;
        initView();
        initController();
    }

    @Override
    void initView() {
        setLanguage();
    }

    @Override
    void initController() {
        authorForm.getCancelButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            clearAllFields();
            authorForm.dispose();
        });

        authorForm.getSaveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
            clearAllFields();
        });
    }

    @Override
    void add() {
          this.authorModel = new AuthorModel();
        if (authorForm.getTextFieldFirstName().getText().equals("") && authorForm.getTextFieldLastName().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("authorcontroller.add.leaveblank.caution"));
        } else {
            authorModel.setFirstName(authorForm.getTextFieldFirstName().getText());
            authorModel.setLastName(authorForm.getTextFieldLastName().getText());
            if (authorForm.getBirthDateChooser().getDateEditor().getDate() != null) {
                authorModel.setBirthDate(authorForm.getBirthDateChooser().getDateEditor().getDate().getTime());
            }
            authorModel.setPhone(authorForm.getTextFieldPhone().getText());
            authorModel.setAddress(authorForm.getTextAreaAddress().getText());
            authorService.add(authorModel);
        }
    }

    public void clearAllFields() {
        authorForm.getTextFieldFirstName().setText(null);
        authorForm.getTextFieldLastName().setText(null);
        authorForm.getBirthDateChooser().setDate(null);
        authorForm.getTextFieldPhone().setText(null);
        authorForm.getTextAreaAddress().setText(null);
    }

    private void setLanguage() {
        authorForm.setTitle(setLanguage("authorform.title"));
        authorForm.getLabelFirstName().setText(setLanguage("authorform.panelsave.labelfirstname"));
        authorForm.getLabelLastName().setText(setLanguage("authorform.panelsave.labellastname"));
        authorForm.getLabelBirthDate().setText(setLanguage("authorform.panelsave.labelbirthdate"));
        authorForm.getLabelPhone().setText(setLanguage("authorform.panelsave.labelPhone"));
        authorForm.getLabelAddress().setText(setLanguage("authorform.panelsave.labeladdress"));
        authorForm.getSaveButton().setText(setLanguage("authorform.panelsave.savebutton"));
        authorForm.getCancelButton().setText(setLanguage("authorform.panelsave.cancelbutton"));        
    }

}
