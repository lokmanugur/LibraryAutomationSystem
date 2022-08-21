/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.author;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.persistancev2.Dao;
import java.sql.ResultSet;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface AuthorDao extends Dao<AuthorModel>{

    public ResultSet search(String string);
    
}
