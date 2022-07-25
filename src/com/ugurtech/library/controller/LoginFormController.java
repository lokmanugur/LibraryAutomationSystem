/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.view.LoginForm;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.persistance.user.UserDaoImpl;
import com.ugurtech.library.service.date.SimpleDate;
import com.ugurtech.library.service.localization.Internationalization;

/**
 *
 * @author ugur
 * 
 */
public class LoginFormController{
    
    private final LoginForm loginForm;
    private final UserDaoImpl userDao;
    private final CurrentUserModel sysUser;
    
    public LoginFormController(LoginForm loginForm){
        sysUser = CurrentUserModel.getInstance();
        userDao = new UserDaoImpl();
        userDao.openConnection();
        this.loginForm=loginForm;
    }
    
    public void userEnter() {
        sysUser.setUserName(loginForm.getUserNameField().getText());
        sysUser.setUserPassword(String.valueOf(loginForm.getUserPaswordField().getPassword()));
        if(userDao.checkUser(sysUser)){
            loginForm.getInfolabel().setText("");
            MainForm.getInstance().getUserLabel().setText(sysUser.getFirstName()+" "+sysUser.getLastName());
            MainForm.getInstance().setVisible(true);
            loginForm.setVisible(false);
            loginForm.getUserNameField().setText("");
            loginForm.getUserPaswordField().setText("");
            SimpleDate.getInstance().setLoginWin(false);
            SimpleDate.getInstance().setSessionTime(sysUser.getSessionTime());
            SimpleDate.getInstance().setTimeStart();
        } else {
            loginForm.getInfolabel().setText(Internationalization.getInstance().getLable("loginform.infolabel"));
        }
    }
    
    public void loginExit(){
        SimpleDate.getInstance().interrupt();
        if(!userDao.isClosed()){
        } else {
            userDao.closeConnection();
        }
        loginForm.dispose();
        MainForm.getInstance().dispose();
    }
}
