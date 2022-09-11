/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.user;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Controller;
import com.ugurtech.library.ab_application.service.user.UserService;
import com.ugurtech.library.ab_application.service.user.UserServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.user.UserDaoImpl;
import com.ugurtech.library.ad_model.UserModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class UserController extends AbstractController implements Controller<UserModel> {
    
    private UserService userService = new UserServiceImpl(new UserDaoImpl());
    
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
