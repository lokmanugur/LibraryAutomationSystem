/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.author;

import com.ugurtech.library.ad_model.AuthorModel;
import com.ugurtech.library.ac_dataaccesslayer.Dao;
import javax.swing.table.TableModel;


/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface AuthorDao extends Dao<AuthorModel>{

    public TableModel search(String string);
    
}
