/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.view.user.UserForm;
import com.ugurtech.library.persistance.user.UserDaoImpl;
import com.ugurtech.library.persistance.user.UserDao;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.model.PersonModel;
import com.ugurtech.library.model.UserModel;
import com.ugurtech.library.model.UserTypeModel;
import com.ugurtech.library.service.localization.Internationalization;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ugur
 * 
 */
public class UserFormController {
    
    private final UserForm userForm;
    private final UserDao userDao;
    private final UserModel userModel;
    private List<UserTypeModel> userTypeList;
    private List<PersonModel> personList;
    public UserFormController(UserForm userForm) {
       this.userForm = userForm;
       this.userDao = new UserDaoImpl();
       this.userModel = new UserModel();
       this.userTypeList = new ArrayList<>();
       this.personList = new ArrayList<>();
    }

    public void addUser() {
        if(checkPassword()&&checkFields()){
            for(UserTypeModel userTypeModel:userTypeList)
                if(userTypeModel.getUserTypeName().equals(userForm.getUserTypeComboBox().getSelectedItem()))
                    userModel.setUserTypeId(userTypeModel.getUserTypeId());
            for(PersonModel personModel:personList)
                if((personModel.getFirstName()+" "+personModel.getLastName()+" "+personModel.getPersonId()).equals(userForm.getPersonComboBox().getSelectedItem()))
                    userModel.setPersonId(personModel.getPersonId());
            userModel.setUserName(userForm.getLoginNameTextField().getText());
            userModel.setUserPassword(String.valueOf(userForm.getPasswordTextField().getPassword()));
            userDao.addUser(userModel);
        }else{UserInfoMessages.getInstance().showInfoMessages("Lütfen Bütün Alanları Eksiksiz Doldurun.");}
    }
    
    public void allPerson(){
        userForm.getPersonComboBox().removeAllItems();
        if(!personList.isEmpty()){
            personList.clear();}
        personList = userDao.allPerson();
        for(PersonModel personModel:personList){
            userForm.getPersonComboBox().addItem(personModel.getFirstName()+" "+personModel.getLastName()+" "+personModel.getPersonId());
        }
    }
    public void allUserType(){
        userForm.getUserTypeComboBox().removeAllItems();
        if(!userTypeList.isEmpty())
            userTypeList.clear();
        userTypeList = userDao.allUserType();
        for(UserTypeModel userTypeModel:userTypeList){
            userForm.getUserTypeComboBox().addItem(userTypeModel.getUserTypeName());
        }
    }
    
    public boolean checkPassword(){
        boolean check=String.valueOf(userForm.getPasswordTextField().getPassword()).equals(String.valueOf(userForm.getPassMatchTextField().getPassword()));
        if(check){
            userForm.getCheckLabel().setForeground(Color.BLACK);
            userForm.getCheckLabel().setText(Internationalization.getInstance().getLable("userformcontroller.password.match"));
        }else{
            userForm.getCheckLabel().setForeground(Color.RED);
            userForm.getCheckLabel().setText(Internationalization.getInstance().getLable("userformcontroller.password.dont.match"));
        }
        return check;
    }
    
    public boolean checkFields(){
    
        return userForm.getUserTypeComboBox().getSelectedItem()!=null&&userForm.getPersonComboBox().getSelectedItem()!=null
                &&userForm.getPasswordTextField().getPassword()!=null&&userForm.getLoginNameTextField().getText()!=null;
    }
}