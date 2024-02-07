/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.classstd;

import com.ugurtech.library.dataaccesslayer.Dao;
import com.ugurtech.library.model.ClassModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface ClassStdDao extends Dao<ClassModel>{
    public TableModel search(String str);
}
