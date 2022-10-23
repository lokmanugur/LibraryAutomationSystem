/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.application.service.usertype;

import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.dataaccesslayer.usertype.UserTypeDao;
import java.util.List;

/**
 *
 * @author Teacher
 */
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeDao userTypeDao;

    public UserTypeServiceImpl(UserTypeDao userTypeDao) {
        this.userTypeDao = userTypeDao;
    }

    @Override
    public List<UserTypeModel> getAll() {
        return userTypeDao.getAll();
    }

    @Override
    public UserTypeModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(UserTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UserTypeModel v) {
        userTypeDao.update(v);
    }

    @Override
    public void delete(int id) {
        userTypeDao.delete(get(id));
    }
    
}
