/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.application.service.login;

import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.dataaccesslayer.login.LoginDao;
import java.util.List;

/**
 *
 * @author Teacher
 */
public class LoginServiceImpl implements LoginService {
    
    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    

    @Override
    public boolean checkExistUsers(){
        return loginDao.checkExistUsers();
    }

    @Override
    public List<CurrentUserModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CurrentUserModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(CurrentUserModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CurrentUserModel v) {
        loginDao.update(v);
    }

    @Override
    public void delete(int id) {
        loginDao.delete(get(id));
    }

    @Override
    public boolean checkUser(CurrentUserModel currentUser) {
        return loginDao.checkUser(currentUser);
    }
    
}
