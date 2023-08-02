/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.usertype;

import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.dataaccesslayer.usertype.UserTypeDao;
import java.util.List;
import javax.swing.table.TableModel;

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
        return userTypeDao.get(id);
    }

    @Override
    public void add(UserTypeModel v) {
        userTypeDao.add(v);
    }

    @Override
    public void update(UserTypeModel v) {
        userTypeDao.update(v);
    }

    @Override
    public void delete(int id) {
        userTypeDao.delete(get(id));
    }

    @Override
    public TableModel search(String searchText) {
       return userTypeDao.search(searchText);
    }

    @Override
    public TableModel options() {
        return userTypeDao.options();
    }
    
}
