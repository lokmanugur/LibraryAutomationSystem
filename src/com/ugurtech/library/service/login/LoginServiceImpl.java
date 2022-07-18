/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.login;

import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.persistancev2.login.LoginDao;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(CurrentUserModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkUser(CurrentUserModel currentUser) {
        return loginDao.checkUser(currentUser);
    }
    
}
