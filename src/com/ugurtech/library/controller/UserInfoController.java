/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.view.user.UserDetailsForm;

/**
 *
 * @author ugur
 */
public class UserInfoController {

    private final UserDetailsForm userDetailForm;
    
    public UserInfoController(UserDetailsForm userDetailsForm) {
        this.userDetailForm=userDetailsForm;
    }
    
    public void userDetails(){
        userDetailForm.getFirstNameTextField().setText(CurrentUserModel.getInstance().getFirstName());
        userDetailForm.getLastNameTextField().setText(CurrentUserModel.getInstance().getLastName());
        userDetailForm.getUserNamePasswordField().setText(CurrentUserModel.getInstance().getUserName());
        userDetailForm.getPasswordField().setText(CurrentUserModel.getInstance().getUserPassword());
        userDetailForm.getBirthDatePicker().setDate(CurrentUserModel.getInstance().getBirthDate());
        userDetailForm.getPhoneTextField().setText(CurrentUserModel.getInstance().getPhone());
        userDetailForm.getAddressTextArea().setText(CurrentUserModel.getInstance().getAddress());
        userDetailForm.getCreateDateTextField().setText(String.valueOf(CurrentUserModel.getInstance().getCreatedDate()));
        userDetailForm.getLastUpdateTextField().setText(String.valueOf(CurrentUserModel.getInstance().getLastUpdate()));
    }
}
