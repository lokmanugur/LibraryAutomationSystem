/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.student;

import com.ugurtech.library.ac_dataaccesslayer.Dao;
import com.ugurtech.library.ad_model.StudentModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Lokman Ugur
 */
public interface StudentDao extends Dao<StudentModel> {

    public TableModel search(String searchText);
  
}

