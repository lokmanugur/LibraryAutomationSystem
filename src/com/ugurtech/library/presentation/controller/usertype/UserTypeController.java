/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.usertype;

import com.ugurtech.library.application.service.usertype.UserTypeService;
import com.ugurtech.library.application.service.usertype.UserTypeServiceImpl;
import com.ugurtech.library.dataaccesslayer.usertype.UserTypeDaoImpl;
import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class UserTypeController extends AbstractController implements Controller<UserTypeModel> {

    private final UserTypeService userTypeService = new UserTypeServiceImpl(new UserTypeDaoImpl());
    @Override
    public List<UserTypeModel> getAll() {
       return userTypeService.getAll();
    }

    @Override
    public UserTypeModel get(int id) {
        return userTypeService.get(id);
    }

    @Override
    public void add(UserTypeModel v) {
        userTypeService.add(v);
    }

    @Override
    public void update(UserTypeModel v) {
        userTypeService.add(v);
    }

    @Override
    public void delete(int id) {
       userTypeService.delete(id);
    }
    
    public TableModel search(String searchText){
       return userTypeService.search(searchText);
    }
    
    public TableModel options(){
       return userTypeService.options();
    }
}
