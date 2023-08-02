/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.presentation.controller.database;

import com.ugurtech.library.model.DatabaseModel;
import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.service.database.DatabaseServiceImpl;

/**
 *
 * @author www.lokmanugur.com
 */
public class DatabaseController extends AbstractController {
    private final DatabaseServiceImpl databaseServiceImpl;

    public DatabaseController() {
        this.databaseServiceImpl = new DatabaseServiceImpl();
    }
    
    protected void add(DatabaseModel databaseModel){
        databaseServiceImpl.add(databaseModel);
    }
    
    protected DatabaseModel get(){
        return databaseServiceImpl.get();
    }
}
