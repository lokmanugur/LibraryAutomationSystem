/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.school;

import com.ugurtech.library.ac_dataaccesslayer.Dao;
import com.ugurtech.library.ad_model.SchoolModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface SchoolDao extends Dao<SchoolModel>{
    public TableModel search(String arg);
}
