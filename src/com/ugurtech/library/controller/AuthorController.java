/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.author.AuthorDao;
import com.ugurtech.library.persistance.author.AuthorDaoImpl;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.view.book.AuthorForm;
import java.util.Date;

/**
 *
 * @author ugur
 */

public class AuthorController {
    
    private final AuthorForm authorForm;
    private final AuthorModel authorModel;
    private final AuthorDao authorDao;

    public AuthorController(AuthorForm authorForm) {
        this.authorForm = authorForm;
        this.authorModel = new AuthorModel();
        this.authorDao = new AuthorDaoImpl();          
    }
    
    public void addAuthor(){
        if(authorForm.getFirstNameTextField().getText().equals("")&&authorForm.getLastNameTextField().getText().equals("")){
            UserInfoMessages.getInstance().showInfoMessages("Lütfen Ad ve Soyad alanlarını doldurunuz.");
        }else{
        authorModel.setFirstName(authorForm.getFirstNameTextField().getText());
        authorModel.setLastName(authorForm.getLastNameTextField().getText());
        if(authorForm.getBirthDateChooser().getDateEditor().getDate()!=null){
        authorModel.setBirthDate(new Date(authorForm.getBirthDateChooser().getDateEditor().getDate().getTime()));}
        authorModel.setPhone(authorForm.getPhoneTextField().getText());
        authorModel.setAddress(authorForm.getAddressTextArea().getText());
        authorDao.addAuthor(authorModel);
        }
    }
    
    public void getAllAuthor(){
        
    }

}
