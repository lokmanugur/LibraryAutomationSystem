/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.usertype;

import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.dataaccesslayer.Dao;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 * 
 */
public interface UserTypeDao extends Dao<UserTypeModel> {
    public TableModel search(String searchText);
    public TableModel options();
}
