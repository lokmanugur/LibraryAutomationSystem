/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.application.service.user;

import com.ugurtech.library.dataaccesslayer.user.UserDao;
import com.ugurtech.library.model.UserModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public TableModel search(String textSearch) {
        return userDao.search(textSearch);
    }

    @Override
    public List<UserModel> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserModel get(int id) {
        return userDao.get(id);
    }

    @Override
    public void add(UserModel v) {
        userDao.add(v);
    }

    @Override
    public void update(UserModel v) {
        userDao.update(v);
    }

    @Override
    public void delete(int id) {
        userDao.delete(get(id));
    }
    
}
