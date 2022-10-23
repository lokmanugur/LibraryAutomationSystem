/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.user;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.user.UserService;
import com.ugurtech.library.application.service.user.UserServiceImpl;
import com.ugurtech.library.dataaccesslayer.user.UserDaoImpl;
import com.ugurtech.library.model.UserModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class UserController extends AbstractController implements Controller<UserModel> {
    
    private final UserService userService = new UserServiceImpl(new UserDaoImpl());
    
    @Override
    public List<UserModel> getAll() {
        return userService.getAll();
    }

    @Override
    public UserModel get(int id) {
        return userService.get(id);
    }

    @Override
    public void add(UserModel v) {
        userService.add(v);
    }

    @Override
    public void update(UserModel v) {
        userService.update(v);
    }

    @Override
    public void delete(int id) {
        userService.delete(id);
    }
    
    public TableModel search(String searchText){
       return userService.search(searchText);
    }
    
}
